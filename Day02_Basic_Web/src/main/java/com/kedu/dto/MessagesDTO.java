package com.kedu.dto;

public class MessagesDTO {
	private int seq;
	private String sender;
	private String message;

	public MessagesDTO() {}
	public MessagesDTO(int seq, String sender, String message) {
		super();
		this.seq = seq;
		this.sender = sender;
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}


}
