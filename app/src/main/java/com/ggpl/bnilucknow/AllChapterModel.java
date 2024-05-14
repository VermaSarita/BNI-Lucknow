package com.ggpl.bnilucknow;
import com.google.gson.annotations.SerializedName;


public class AllChapterModel {
    @SerializedName("id")
    public int id;
    @SerializedName("img")
    public String img;
    @SerializedName("Chapter")
    public String chapter;


    public AllChapterModel(int id, String img, String chapter) {
        this.id = id;
        this.img = img;
        this.chapter = chapter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

}
