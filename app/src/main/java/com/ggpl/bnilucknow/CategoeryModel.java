package com.ggpl.bnilucknow;

public class CategoeryModel {
    private int imgid;
    private String title;

    public CategoeryModel(int imgid, String title) {
        this.imgid = imgid;
        this.title = title;
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
}
