package main.dictionary;

import main.exceptions.DifferentWordLengthException;
import main.graph.Graph;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {

    private Set<Word> words;
    private int wordsLength;
    private Graph graph = null;

    public Dictionary(int wordsLength) {
        this.wordsLength = wordsLength;
        this.words = new HashSet<>();
    }

    public void addWord(Word word) {
        if (word.getLength() == getWordsLength()) {
            words.add(word);
        } else {
            throw new DifferentWordLengthException();
        }
    }

    public void setGraph() {
        if (this.graph == null)
            this.graph = new Graph(words);
    }

    public int getWordsLength() {
        return wordsLength;
    }

    public boolean contains(Word word) {
        return words.contains(word);
    }

    public Set<Word> getWords() {
        return words;
    }

    public Graph getGraph() {
        return graph;
    }
}
