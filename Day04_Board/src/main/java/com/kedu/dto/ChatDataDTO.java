package com.kedu.dto;

public class ChatDataDTO {
	private String type;
	private Object data;
	
	public ChatDataDTO() {}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ChatDataDTO(String type, Object data) {
		super();
		this.type = type;
		this.data = data;
	}
}
