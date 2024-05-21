package com.ggpl.bnilucknow;
import com.google.gson.annotations.SerializedName;


public class AllChapterModel {
    @SerializedName("id")
    public int id;
    @SerializedName("chapter")
    public String chapter;
    @SerializedName("image")
    public String image;
    @SerializedName("imgpath")
    public String imgpath;

    public AllChapterModel(int id, String chapter, String image, String imgpath) {
        this.id = id;
        this.chapter = chapter;
        this.image = image;
        this.imgpath = imgpath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
