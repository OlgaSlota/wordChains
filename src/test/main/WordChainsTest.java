package test.main;

import main.dictionary.Word;
import main.main.WordChains;
import main.exceptions.NotAValidWordException;
import main.graph.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordChainsTest {

    @Test
    public void getWordChain_shouldReturnList() {
        try {
            Assert.assertTrue(WordChains.getWordChain("one", "two") instanceof List);
        } catch (NotAValidWordException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getWordChain_shouldReturnTheSameOneElem_whenWordsEqual() {
        List<Vertex> result = null;
        try {
            result = WordChains.getWordChain("first", "first");
        } catch (NotAValidWordException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(result.size() == 1);
        Assert.assertEquals(new Vertex(new Word("first")), result.get(0));
    }

    @Test(expected = NotAValidWordException.class)
    public void getWordChain_shouldThrowNotAValidWordException_whenInvalidWords() throws NotAValidWordException {
        WordChains.getWordChain("wrr", "qwwe");
    }
}
