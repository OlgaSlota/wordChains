package test.dictionary;

import main.dictionary.DictionariesProvider;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

public class DictionariesProviderTest {

    @Test
    public void getDictionaries_shouldReturnMap_whenPathValid() {
        Assert.assertTrue(DictionariesProvider.getDictionaries("wordlist.txt").get() instanceof Map);
    }

    @Test
    public void getDictionaries_shouldReturnEmpty_whenPathInvalid() {
        Assert.assertEquals(DictionariesProvider.getDictionaries("notExistingFileName.txt"), Optional.empty());
    }

}
