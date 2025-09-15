package com.kedu.dto;

public class FilesDTO {
	private int seq;
	private String writer;
	private String oriname;
	private String sysname;
	private int parent_seq;
	
	public FilesDTO() {}
	public FilesDTO(int seq, String writer, String oriname, String sysname, int parent_seq) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.oriname = oriname;
		this.sysname = sysname;
		this.parent_seq = parent_seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	
	
}
