package bg.softuni.exceptions;

public class InvalidPathException extends RuntimeException{
    private static final String INVALID_PATH = "The sourse does not exist";

    public InvalidPathException() {
        super(INVALID_PATH);
    }

    public InvalidPathException(String message) {
        super(message);
    }
}
