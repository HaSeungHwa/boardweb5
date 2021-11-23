package com.koreait.board5.model;

public class BoardVO {
    private int ibaord;
    private String title;
    private String ctnt;
    private int writer;
    private String rdt;
    private String mdt;
    private String writerNm;

    public String getWriterNm() {
        return writerNm;
    }

    public void setWriterNm(String writerNm) {
        this.writerNm = writerNm;
    }

    public int getIbaord() {
        return ibaord;
    }

    public void setIbaord(int ibaord) {
        this.ibaord = ibaord;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCtnt() {
        return ctnt;
    }

    public void setCtnt(String ctnt) {
        this.ctnt = ctnt;
    }

    public int getWriter() {
        return writer;
    }

    public void setWriter(int writer) {
        this.writer = writer;
    }

    public String getRdt() {
        return rdt;
    }

    public void setRdt(String rdt) {
        this.rdt = rdt;
    }

    public String getMdt() {
        return mdt;
    }

    public void setMdt(String mdt) {
        this.mdt = mdt;
    }
}
