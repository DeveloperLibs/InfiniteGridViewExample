
package com.devlibs.infinitegridviewexample.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Info {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private Long mResults;
    @SerializedName("seed")
    private String mSeed;
    @SerializedName("version")
    private String mVersion;

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public Long getResults() {
        return mResults;
    }

    public void setResults(Long results) {
        mResults = results;
    }

    public String getSeed() {
        return mSeed;
    }

    public void setSeed(String seed) {
        mSeed = seed;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

}
