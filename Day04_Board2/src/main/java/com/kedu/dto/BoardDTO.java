package com.kedu.dto;

import java.util.Date;

public class BoardDTO {
    private int seq;
    private String title;
    private String content;
    private String writer;
    private Date regDate;

    // getter, setter
    public int getSeq() { return seq; }
    public void setSeq(int seq) { this.seq = seq; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public Date getRegDate() { return regDate; }
    public void setRegDate(Date regDate) { this.regDate = regDate; }
}