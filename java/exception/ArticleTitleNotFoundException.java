package exception;

public class ArticleTitleNotFoundException extends RuntimeException {
    public ArticleTitleNotFoundException() {
        super();
    }

    public ArticleTitleNotFoundException(String message) {
        super(message);
    }

    public ArticleTitleNotFoundException(RuntimeException e) {
        super(e);
    }
}
