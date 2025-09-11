package com.kedu.dto;

public class ContactDTO {
	private int seq;
	private String name;
	private String phone;
	
	public ContactDTO() {}

	public ContactDTO(int seq, String name, String phone) {
		super();
		this.seq = seq;
		this.name = name;
		this.phone = phone;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
