package az.maqa.spring.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class RequestBook {

	@NotEmpty(message = "Title can not be null or empty")
	private String title;

	@Positive(message = "Copies can not be negative number")
	private Integer copies;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCopies() {
		return copies;
	}

	public void setCopies(Integer copies) {
		this.copies = copies;
	}

}
