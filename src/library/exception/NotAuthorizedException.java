package library.exception;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException() {
        super("Action is forbidden to current user");
    }
}
