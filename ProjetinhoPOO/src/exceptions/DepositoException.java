package exceptions;

public class DepositoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepositoException() {
		super();
	}

	public DepositoException(String message) {
		super(message);
	}

}
