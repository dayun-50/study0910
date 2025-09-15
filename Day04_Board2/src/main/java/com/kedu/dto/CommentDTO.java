package com.kedu.dto;

public class CommentDTO {
	private int seq;
	private int prent_seq;
	private String content;
	private String writer;
	private String coment_date;
	
	public CommentDTO() {}

	public CommentDTO(int seq, int prent_seq, String content, String writer, String coment_date) {
		super();
		this.seq = seq;
		this.prent_seq = prent_seq;
		this.content = content;
		this.writer = writer;
		this.coment_date = coment_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getPrent_seq() {
		return prent_seq;
	}

	public void setPrent_seq(int prent_seq) {
		this.prent_seq = prent_seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getComent_date() {
		return coment_date;
	}

	public void setComent_date(String coment_date) {
		this.coment_date = coment_date;
	}

	
	
}
