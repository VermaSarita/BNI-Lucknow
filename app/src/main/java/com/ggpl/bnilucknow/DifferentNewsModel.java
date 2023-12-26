package com.ggpl.bnilucknow;

public class DifferentNewsModel {
    private int imgid;
    private String title;
    private String text;

    public DifferentNewsModel(int imgid, String title, String text) {
        this.imgid = imgid;
        this.title = title;
        this.text = text;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
