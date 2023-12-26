package com.ggpl.bnilucknow;

public class NewsModel {

    private int imgid;
    private String title;
    private String text;
    private String userName;

    public NewsModel(int imgid, String title, String text, String userName) {
        this.imgid = imgid;
        this.title = title;
        this.text = text;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
