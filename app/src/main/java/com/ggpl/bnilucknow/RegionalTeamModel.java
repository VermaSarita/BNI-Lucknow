package com.ggpl.bnilucknow;

public class RegionalTeamModel {
    private int imgid;
    private String title;
    private String text;
    private String text2;

    public RegionalTeamModel(int imgid, String title, String text, String text2) {
        this.imgid = imgid;
        this.title = title;
        this.text = text;
        this.text2 = text2;
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

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
