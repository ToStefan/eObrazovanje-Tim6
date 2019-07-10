package eobrazovanje.tim6.app.exception;

public class UsernameNotAvailibleException extends RuntimeException {
	
	private static final long serialVersionUID = -2471681367617612207L;

	public UsernameNotAvailibleException(String message) {
        super(message);
    }

    public UsernameNotAvailibleException(String message, Throwable cause) {
        super(message, cause);
    }

}
