package bg.softuni.exceptions;

public class KeyNotFoundException extends IllegalArgumentException{
    private static final String INVALID_NUMBER_OF_SCORES = "The number of scores for the given course is greater than the possible.";

    public KeyNotFoundException() {
        super(INVALID_NUMBER_OF_SCORES);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}
