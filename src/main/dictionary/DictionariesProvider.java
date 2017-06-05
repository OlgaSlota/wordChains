package main.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class DictionariesProvider {

    private static Map<Integer, Dictionary> dictionaries = new HashMap<>();

    public static Optional<Map<Integer, Dictionary>> getDictionaries(String path) {
        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            stream.forEach(line -> addToDictionary(line));
            return Optional.of(dictionaries);
        } catch (IOException e) {
            System.out.println("Dictionary file not found " + e.getMessage());
        }
        return Optional.empty();
    }

    public static void setUpGraphForLength(int length) {
        dictionaries.get(length).setGraph();
    }

    private static void addToDictionary(String line) {
        Word word = new Word(line.trim().toLowerCase());
        int wordLength = word.getLength();
        dictionaries.putIfAbsent(wordLength, new Dictionary(wordLength));
        dictionaries.get(wordLength).addWord(word);
    }
}
