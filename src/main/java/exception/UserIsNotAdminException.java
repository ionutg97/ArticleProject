package exception;

public class UserIsNotAdminException extends RuntimeException {
    public UserIsNotAdminException() {
        super();
    }

    public UserIsNotAdminException(String message) {
        super(message);
    }

    public UserIsNotAdminException(RuntimeException e) {
        super(e);
    }
}