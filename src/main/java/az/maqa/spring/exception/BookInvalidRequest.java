package az.maqa.spring.exception;

public class BookInvalidRequest extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookInvalidRequest(String message) {
		super(message);
	}
	
}
