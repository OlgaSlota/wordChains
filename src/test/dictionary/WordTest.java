package test.dictionary;

import main.dictionary.Word;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordTest {

    private Word word;
    private String str;

    @Before
    public void setUp() {
        str = "something";
        word = new Word(str);
    }

    @Test
    public void getLength_shouldBeStringLength() {
        Assert.assertEquals(word.getLength(), str.length());
    }

    @Test
    public void equals_shouldReturnTrue_whenEqualWordContents() {
        Assert.assertTrue(new Word("letter").equals(new Word("letter")));
    }

    @Test
    public void equals_shouldReturnFalse_whenDifferentWords() {
        Assert.assertFalse(new Word("letter").equals(new Word("let")));
        Assert.assertFalse(new Word("letter").equals(new String("letter")));
        Assert.assertFalse(new Word("letter").equals(null));
    }

    @Test
    public void hashCode_shouldBeEqual_whenEqualWordContents() {
        Assert.assertTrue(new Word("letter").hashCode() == new Word("letter").hashCode());
    }

    @Test
    public void isNeighbour_shouldReturnTrue_whenOneLetterDifferentWords() {
        Assert.assertTrue(new Word("let").isNeighbourTo(new Word("get")));
    }

    @Test
    public void isNeighbour_shouldReturnFalse_whenEqualWords() {
        Assert.assertFalse(new Word("let").isNeighbourTo(new Word("let")));
    }

    @Test
    public void isNeighbour_shouldReturnFalse_whenDifferentLengthWords() {
        Assert.assertFalse(new Word("let").isNeighbourTo(new Word("letter")));
    }
}
