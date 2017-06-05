package main.main;

import main.dictionary.DictionariesProvider;
import main.dictionary.Dictionary;
import main.dictionary.Word;
import main.exceptions.NotAValidWordException;
import main.graph.Graph;
import main.graph.Vertex;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;
import java.util.Optional;


public class WordChains {

    public static List<Vertex> getWordChain(String startWord, String endWord) throws NotAValidWordException {

        Map<Integer, Dictionary> dictionaryMap = DictionariesProvider.getDictionaries("wordlist.txt").get();

        if (startWord.equals(endWord)) {
            return Arrays.asList(new Vertex(new Word(startWord)));
        } else {
            DictionariesProvider.setUpGraphForLength(startWord.length());
            Graph graph = dictionaryMap.get(startWord.length()).getGraph();
            
            Vertex startVertex = getVertexForStringOrThrow(startWord, graph);
            Vertex endVertex = getVertexForStringOrThrow(endWord, graph);
            Optional<List<Vertex>> resultChain = graph.bfs(startVertex, endVertex);
            if (resultChain.isPresent()) {
                return resultChain.get();
            }
            System.out.println("Word chain does not exist in the given dictionary.");
            return new LinkedList<>();
        }
    }

    private static Vertex getVertexForStringOrThrow(String word, Graph graph) throws NotAValidWordException {
        Optional<Vertex> vertexOptional = graph.vertexForString(word);
        if (!vertexOptional.isPresent()) {
            throw new NotAValidWordException(word);
        }
        return vertexOptional.get();
    }
}
