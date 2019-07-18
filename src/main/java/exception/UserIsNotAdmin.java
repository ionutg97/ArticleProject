package exception;

public class UserIsNotAdmin extends RuntimeException {
    public UserIsNotAdmin() {
        super();
    }

    public UserIsNotAdmin(String message) {
        super(message);
    }

    public UserIsNotAdmin(RuntimeException e) {
        super(e);
    }
}