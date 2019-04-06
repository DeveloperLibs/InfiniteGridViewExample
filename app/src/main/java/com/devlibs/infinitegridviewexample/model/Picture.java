
package com.devlibs.infinitegridviewexample.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Picture {

    @SerializedName("large")
    private String mLarge;
    @SerializedName("medium")
    private String mMedium;
    @SerializedName("thumbnail")
    private String mThumbnail;

    public String getLarge() {
        return mLarge;
    }

    public void setLarge(String large) {
        mLarge = large;
    }

    public String getMedium() {
        return mMedium;
    }

    public void setMedium(String medium) {
        mMedium = medium;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

}
