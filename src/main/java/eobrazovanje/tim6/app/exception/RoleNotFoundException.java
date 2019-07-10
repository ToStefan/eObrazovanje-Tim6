package eobrazovanje.tim6.app.exception;

public class RoleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2873980553062670197L;

	public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
