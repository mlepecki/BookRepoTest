package pl.michalm.exception;

public class BookNotFoundException extends RuntimeException {

    private static final String DEFAULT_MSG = "Book not found";

    public BookNotFoundException(final String message) {
        super(message);
    }

    public BookNotFoundException() {
        super(DEFAULT_MSG);
    }
}
