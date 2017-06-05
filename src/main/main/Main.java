package main.main;

import main.exceptions.NotAValidWordException;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Type q to exit.");

        while (true) {
            System.out.println("\nStart word: ");
            String startWord = readInput();

            String endWord;
            do {
                System.out.println("End word of the same length: ");
                endWord = readInput();
            } while (endWord.length() != startWord.length());

            System.out.println("Result... ");
            try {
                WordChains.getWordChain(startWord, endWord).forEach(vertex -> System.out.print(vertex + " "));
            } catch (NotAValidWordException e) {
                System.out.println("Cannot find word chain. " + e.getMessage() + " Try again.");
            }

        }
    }

    private static String readInput() {
        String word = scanner.next().trim().toLowerCase();
        if (word.equals("q")) {
            System.out.println("Exiting..");
            System.exit(0);
            return "";
        } else {
            return word;
        }
    }
}
