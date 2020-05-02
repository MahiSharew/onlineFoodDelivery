package edu.mum.dream.exceptionhandler;

import java.util.Date;
import java.util.List;

public class ErrorResponse {
	private int status;
	private List<String> message;
	private Date timeStamp;
	
	public ErrorResponse() {
		
	}
	public ErrorResponse(int status, List<String> message, Date timeStamp) {
		
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
