package pl.cwanix.opensun.utils.encryption.exceptions;

public class InvalidKeyException extends Exception {

	private static final long serialVersionUID = 7422103356203116314L;
	
	public InvalidKeyException(String errorMessage) {
		super(errorMessage);
	}
	
	public InvalidKeyException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

}
