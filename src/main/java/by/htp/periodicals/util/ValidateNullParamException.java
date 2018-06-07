package by.htp.periodicals.util;

public class ValidateNullParamException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6476347435439510910L;

	public ValidateNullParamException() {
		super();	
	}

	public ValidateNullParamException(String message) {
		super(message);
	}

	public ValidateNullParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateNullParamException(Throwable cause) {
		super(cause);
	}
	
	

}
