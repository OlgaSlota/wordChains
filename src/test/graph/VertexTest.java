package test.graph;

import main.dictionary.Word;
import main.graph.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class VertexTest {

    private Word word1;
    private Word word2;
    private Word word3;
    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;

    @Before
    public void setUp() {
        word1 = new Word("something");
        word2 = new Word("gold");
        word3 = new Word("sold");
        vertex1 = new Vertex(word1);
        vertex2 = new Vertex(word2);
        vertex3 = new Vertex(word1);
    }

    @Test
    public void equals_shouldReturnTrue_whenEqualWordsContent() {
        Assert.assertTrue(vertex1.equals(vertex3));
        Assert.assertTrue(vertex1.equals(vertex1));
        Assert.assertTrue(vertex2.equals(new Vertex(word2)));
    }

    @Test
    public void equals_shouldReturnFalse_whenUnequalWordsContent() {
        Assert.assertFalse(vertex1.equals(vertex2));
        Assert.assertFalse(vertex1.equals(null));
    }

    @Test
    public void hashCode_shouldBeEqual_whenEqualWords() {
        Assert.assertTrue(vertex1.hashCode() == vertex3.hashCode());
        Assert.assertTrue(vertex1.hashCode() == new Vertex(word1).hashCode());
    }

    @Test
    public void getNeighbours_shouldReturnEmptySet_beforeNeighboursAdded() {
        Assert.assertTrue(vertex1.getNeighbours() instanceof Set);
        Assert.assertTrue(vertex1.getNeighbours().isEmpty());
    }

    @Test
    public void getNeighbours_shouldReturnNonEmptySet_afterNeighboursAdded() {
        vertex1.addNeighbour(new Vertex(word3));
        Assert.assertFalse(vertex1.getNeighbours().isEmpty());
    }


}
