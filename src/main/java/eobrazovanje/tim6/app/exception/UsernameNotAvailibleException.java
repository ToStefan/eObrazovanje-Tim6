package eobrazovanje.tim6.app.exception;

public class UsernameNotAvailibleException extends RuntimeException {
	
	public UsernameNotAvailibleException(String message) {
        super(message);
    }

    public UsernameNotAvailibleException(String message, Throwable cause) {
        super(message, cause);
    }

}
