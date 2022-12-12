package br.com.tarefa.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long timesTamp;
	private Integer status;
	private String message;
	
	public StandardError() {
	}

	public StandardError(Long timesTamp, Integer status, String message) {
		super();
		this.timesTamp = timesTamp;
		this.status = status;
		this.message = message;
	}

	public Long getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
