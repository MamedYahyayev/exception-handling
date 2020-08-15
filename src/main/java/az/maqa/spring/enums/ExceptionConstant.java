package az.maqa.spring.enums;

public enum ExceptionConstant {

	BOOK_NOT_FOUND(101), BOOK_INVALID_REQUEST(102);

	private int value;

	ExceptionConstant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
