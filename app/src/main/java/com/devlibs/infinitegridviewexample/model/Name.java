
package com.devlibs.infinitegridviewexample.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Name {

    @SerializedName("first")
    private String mFirst;
    @SerializedName("last")
    private String mLast;
    @SerializedName("title")
    private String mTitle;

    public String getFirst() {
        return mFirst.toUpperCase();
    }

    public void setFirst(String first) {
        mFirst = first;
    }

    public String getLast() {
        return mLast;
    }

    public void setLast(String last) {
        mLast = last;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
