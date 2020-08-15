package az.maqa.spring.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import az.maqa.spring.enums.ExceptionConstant;

@RestControllerAdvice
public class HandleExceptionController extends ResponseEntityExceptionHandler {

	@Value("${send.report.url}")
	private String sendReportUrl;

	@Value("${api.version}")
	private Double apiVersion;

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ResponseException> handleBookNotFoundException(BookNotFoundException e) {
		ResponseErrorDetails details = new ResponseErrorDetails("/books/id", sendReportUrl, "Not Found",
				"find Book By Id");
		Error error = new Error((double) ExceptionConstant.BOOK_NOT_FOUND.getValue(), e.getMessage());
		List<Error> errors = new ArrayList<Error>();
		errors.add(error);

		ResponseException exception = new ResponseException(apiVersion, errors, details);

		return new ResponseEntity<ResponseException>(exception, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ResponseErrorDetails details = new ResponseErrorDetails("/books", sendReportUrl, "Invalid Request",
				"Insert Book");

		List<Error> errorList = new ArrayList<Error>();

		double subcode = 0.1;

		for (ObjectError err : e.getBindingResult().getAllErrors()) {
			Error error = new Error();
			error.setMessage(err.getDefaultMessage());
			error.setCode(ExceptionConstant.BOOK_INVALID_REQUEST.getValue() + subcode);
			errorList.add(error);
			subcode += 0.1;
		}

		ResponseException exception = new ResponseException(apiVersion, errorList, details);

		return new ResponseEntity<Object>(exception, HttpStatus.BAD_REQUEST);
	}

}
