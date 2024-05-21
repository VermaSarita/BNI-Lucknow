package com.ggpl.bnilucknow.Model.MasterModel;
import com.google.gson.annotations.SerializedName;


public class MaestrosModel {
    public int id;
    @SerializedName("CID")
    public int cID;
    @SerializedName("Category")
    public String category;
    public String initial;
    @SerializedName("FName")
    public String fName;
    @SerializedName("LName")
    public String lName;
    @SerializedName("BGroup")
    public String bGroup;
    @SerializedName("DOB")
    public String dOB;
    @SerializedName("Number")
    public String number;
    @SerializedName("Email")
    public String email;
    @SerializedName("City")
    public String city;
    @SerializedName("Address")
    public String address;
    @SerializedName("Facebook")
    public String facebook;
    @SerializedName("Insta")
    public String insta;
    @SerializedName("Youtube")
    public String youtube;
    @SerializedName("Twitter")
    public String twitter;
    @SerializedName("Linkedin")
    public String linkedin;
    @SerializedName("Website")
    public String website;
    @SerializedName("CName")
    public String cName;
    @SerializedName("Clogo")
    public String clogo;
    public String logopath;
    @SerializedName("Mphtopath")
    public String mphtopath;
    @SerializedName("MPhoto")
    public String mPhoto;
    @SerializedName("Ask")
    public String ask;
    @SerializedName("Give")
    public String give;
    @SerializedName("Business")
    public String business;

    public MaestrosModel(int id, int cID, String category, String initial, String fName, String lName, String bGroup, String dOB, String number, String email, String city, String address, String facebook, String insta, String youtube, String twitter, String linkedin, String website, String cName, String clogo, String logopath, String mphtopath, String mPhoto, String ask, String give, String business) {
        this.id = id;
        this.cID = cID;
        this.category = category;
        this.initial = initial;
        this.fName = fName;
        this.lName = lName;
        this.bGroup = bGroup;
        this.dOB = dOB;
        this.number = number;
        this.email = email;
        this.city = city;
        this.address = address;
        this.facebook = facebook;
        this.insta = insta;
        this.youtube = youtube;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.website = website;
        this.cName = cName;
        this.clogo = clogo;
        this.logopath = logopath;
        this.mphtopath = mphtopath;
        this.mPhoto = mPhoto;
        this.ask = ask;
        this.give = give;
        this.business = business;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getbGroup() {
        return bGroup;
    }

    public void setbGroup(String bGroup) {
        this.bGroup = bGroup;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getClogo() {
        return clogo;
    }

    public void setClogo(String clogo) {
        this.clogo = clogo;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public String getMphtopath() {
        return mphtopath;
    }

    public void setMphtopath(String mphtopath) {
        this.mphtopath = mphtopath;
    }

    public String getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getGive() {
        return give;
    }

    public void setGive(String give) {
        this.give = give;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
