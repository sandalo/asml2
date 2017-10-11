package asmlbuilder.exception;

public class ASMLException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5585316485850902011L;

	public ASMLException(Throwable e) {
		super(e);
	}
	
	public ASMLException(String e) {
		super(e);
	}

    public ASMLException(String message, Throwable cause) {
        super(message, cause);
    }
}
