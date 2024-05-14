package com.ggpl.bnilucknow.Model.Chapter;
import com.google.gson.annotations.SerializedName;

public class categoeryModel {

    @SerializedName("id")
    public int id;
    @SerializedName("Category")
    public String category;
    @SerializedName("Image")
    public String Image;

    public categoeryModel(int id, String category, String image) {
        this.id = id;
        this.category = category;
        Image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
