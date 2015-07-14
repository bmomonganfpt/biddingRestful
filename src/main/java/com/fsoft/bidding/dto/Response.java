package com.fsoft.bidding.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
