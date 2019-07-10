package eobrazovanje.tim6.app.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1319176479517346966L;

	public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
