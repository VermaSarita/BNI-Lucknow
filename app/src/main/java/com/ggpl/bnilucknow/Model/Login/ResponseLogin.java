package com.ggpl.bnilucknow.Model.Login;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("Status")
    public boolean status;
    @SerializedName("Error")
    public String error;

    public ResponseLogin(boolean status, String error) {
        this.status = status;
        this.error = error;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
