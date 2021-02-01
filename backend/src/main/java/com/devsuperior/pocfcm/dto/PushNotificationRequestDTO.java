package com.devsuperior.pocfcm.dto;

import java.io.Serializable;

public class PushNotificationRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private String message;
	private String token;
	
	public PushNotificationRequestDTO() {
	}

	public PushNotificationRequestDTO(String title, String message, String token) {
		super();
		this.title = title;
		this.message = message;
		this.token = token;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
