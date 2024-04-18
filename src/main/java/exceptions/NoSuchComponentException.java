package exceptions;

public class NoSuchComponentException extends RuntimeException {
    public NoSuchComponentException(String message) {
        super(message);
    }
}
