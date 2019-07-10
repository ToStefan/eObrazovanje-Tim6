package eobrazovanje.tim6.app.exception;

public class FileStorageException extends RuntimeException {
	
	private static final long serialVersionUID = -3233844083918638066L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
