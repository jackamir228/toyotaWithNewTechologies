package exceptions;

public class CarNotFoundInStorageException extends Exception {
    public CarNotFoundInStorageException(String message) {
        super(message);
    }
}
