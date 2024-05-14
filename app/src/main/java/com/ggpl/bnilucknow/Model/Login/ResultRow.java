package com.ggpl.bnilucknow.Model.Login;

import com.google.gson.annotations.SerializedName;

public class ResultRow {
    public int id;
    @SerializedName("UserName")
    public String userName;
    @SerializedName("Email")
    public String email;
    @SerializedName("Password")
    public String password;
    @SerializedName("IsActive")
    public int isActive;

    public ResultRow(int id, String userName, String email, String password, int isActive) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
