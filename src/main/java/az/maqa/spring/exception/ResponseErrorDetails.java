package az.maqa.spring.exception;

public class ResponseErrorDetails {

	private String domain;

	private String sendReport;

	private String reason;

	private String action;

	public ResponseErrorDetails() {

	}

	public ResponseErrorDetails(String domain, String sendReport, String reason, String action) {
		this.domain = domain;
		this.sendReport = sendReport;
		this.reason = reason;
		this.action = action;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSendReport() {
		return sendReport;
	}

	public void setSendReport(String sendReport) {
		this.sendReport = sendReport;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
