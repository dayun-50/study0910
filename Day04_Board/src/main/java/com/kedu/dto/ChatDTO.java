package com.kedu.dto;

public class ChatDTO {
	private int seq;
	private String userName;
	private String message;
	private String mDate;
	
	public ChatDTO() {}

	public ChatDTO(int seq, String userName, String message, String mDate) {
		super();
		this.seq = seq;
		this.userName = userName;
		this.message = message;
		this.mDate = mDate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	
}
