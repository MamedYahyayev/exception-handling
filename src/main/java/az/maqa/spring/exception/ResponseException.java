package az.maqa.spring.exception;

import java.util.List;

public class ResponseException {

	private Double apiVersion;

	private List<Error> errors;

	private ResponseErrorDetails details;

	public ResponseException() {
		// TODO Auto-generated constructor stub
	}

	public ResponseException(Double apiVersion, List<Error> errors, ResponseErrorDetails details) {
		this.apiVersion = apiVersion;
		this.errors = errors;
		this.details = details;
	}

	public Double getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(Double apiVersion) {
		this.apiVersion = apiVersion;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public ResponseErrorDetails getDetails() {
		return details;
	}

	public void setDetails(ResponseErrorDetails details) {
		this.details = details;
	}

}
