
package com.devlibs.infinitegridviewexample.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Result {

    @SerializedName("gender")
    private String mGender;
    @SerializedName("name")
    private Name mName;
    @SerializedName("picture")
    private Picture mPicture;

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public Name getName() {
        return mName;
    }


    public void setName(Name name) {
        mName = name;
    }

    public Picture getPicture() {
        return mPicture;
    }

    public void setPicture(Picture picture) {
        mPicture = picture;
    }

}
