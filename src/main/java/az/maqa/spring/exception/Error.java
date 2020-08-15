package az.maqa.spring.exception;

public class Error {
	private Double code;
	private String message;

	public Error() {

	}

	public Error(Double code, String message) {
		this.code = code;
		this.message = message;
	}

	public Double getCode() {
		return code;
	}

	public void setCode(Double code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
