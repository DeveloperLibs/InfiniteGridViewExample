
package com.devlibs.infinitegridviewexample.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RandomUser {

    @SerializedName("info")
    private Info mInfo;

    @SerializedName("results")
    private List<Result> mResults;

    public Info getInfo() {
        return mInfo;
    }

    public void setInfo(Info info) {
        mInfo = info;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

}
