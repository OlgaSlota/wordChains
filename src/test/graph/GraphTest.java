package test.graph;

import main.dictionary.Word;
import main.graph.Graph;
import main.graph.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GraphTest {

    public Word word1;
    public Word word2;
    public Word word3;
    public Word word4;
    public Vertex vertex1;
    public Vertex vertex2;
    public Set<Word> words;
    public Graph graph;

    @Before
    public void setUp() {
        word1 = new Word("some");
        word2 = new Word("gold");
        word3 = new Word("sold");
        word4 = new Word("sole");
        vertex1 = new Vertex(word1);
        vertex2 = new Vertex(word2);
        words = new HashSet<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        graph = new Graph(words);
    }

    @Test
    public void getVertices_shouldReturnNonEmptyList_afterInitWithNonEmptySet() {
        Assert.assertFalse(graph.getVertices().isEmpty());
    }

    @Test
    public void vertexForString_shouldBeEqualVertex_whenEqualWords() {
        Assert.assertEquals(vertex1, graph.vertexForString(word1.getContent()).get());
    }

    @Test
    public void vertexForString_shouldBeEmpty_whenNoSuchWord() {
        Optional<Vertex> vertexOptional = graph.vertexForString("notFound");
        Assert.assertFalse(vertexOptional.isPresent());
    }

    @Test
    public void bfs_shouldReturnNonEmptyList_whenChainExists() {
        Vertex v1 = graph.vertexForString("some").get();
        Vertex v2 = graph.vertexForString("gold").get();
        Assert.assertFalse(graph.bfs(v1, v2).get().isEmpty());
    }

}
