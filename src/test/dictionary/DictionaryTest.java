package test.dictionary;

import main.dictionary.Dictionary;
import main.dictionary.Word;
import main.exceptions.DifferentWordLengthException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class DictionaryTest {

    private Dictionary dictionary7lenWords;

    @Before
    public void setUp() {
        dictionary7lenWords = new Dictionary(7);
    }

    @Test
    public void getWords_shouldReturnSet() {
        Assert.assertTrue(dictionary7lenWords.getWords() instanceof Set);
    }

    @Test
    public void getWords_shouldNotBeEmpty_afterValidWordAdded() {
        dictionary7lenWords.addWord(new Word("example"));
        Assert.assertFalse(dictionary7lenWords.getWords().isEmpty());
    }

    @Test
    public void contains_shouldBeTrue_whenValidWordAdded() {
        Word word = new Word("example");
        dictionary7lenWords.addWord(word);
        Assert.assertTrue(dictionary7lenWords.contains(word));
    }

    @Test(expected = DifferentWordLengthException.class)
    public void getWords_shouldBeEmpty_afterInvalidWordAdded() {
        Dictionary dictionary3lenWords = new Dictionary(3);
        dictionary3lenWords.addWord(new Word("example"));
        Assert.assertTrue(dictionary3lenWords.getWords().isEmpty());
    }

    @Test
    public void getWords_shouldNotChangeSize_afterTheSameWordAdded() {
        Dictionary dictionary3lenWords = new Dictionary(3);
        dictionary3lenWords.addWord(new Word("cat"));
        dictionary3lenWords.addWord(new Word("let"));
        dictionary3lenWords.addWord(new Word("her"));
        dictionary3lenWords.addWord(new Word("dog"));
        int sizeBefore = dictionary3lenWords.getWords().size();

        dictionary3lenWords.addWord(new Word("dog"));
        int sizeAfter = dictionary3lenWords.getWords().size();

        Assert.assertEquals(sizeBefore, sizeAfter);
    }
}
