package Project.exceptions;

/**
 * The InvalidInputException class represents an exception thrown when invalid text field input is encountered.
 */
public class InvalidInputException extends RuntimeException {

    /**
     * Constructs a new InvalidInputException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public InvalidInputException(String message) {
        super(message);
    }
}