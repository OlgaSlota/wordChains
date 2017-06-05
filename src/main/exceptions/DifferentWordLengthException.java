package main.exceptions;

public class DifferentWordLengthException extends RuntimeException {
    public DifferentWordLengthException() {
        super("Words of unequal length.");
    }

}
