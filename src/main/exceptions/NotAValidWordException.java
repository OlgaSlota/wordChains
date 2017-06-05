package main.exceptions;

public class NotAValidWordException extends Exception {
    public NotAValidWordException(String word) {
        super("Given word is not in dictionary: " + word + ".");
    }
}
