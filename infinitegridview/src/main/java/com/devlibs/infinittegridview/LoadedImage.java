package com.devlibs.infinittegridview;

import android.net.Uri;

public class LoadedImage {

    private Uri mUri;
    private int id;
    private String url;
    private String label;
    private Object customData;

    public LoadedImage(Uri uri) {
        mUri = uri;
    }

    public LoadedImage(Uri uri, int id, String label) {
        this.mUri = uri;
        this.id = id;
        this.label = label;
    }

    public LoadedImage(String uri) {
        url = uri;
    }

    public LoadedImage(String uri, int id, String label) {
        url = uri;
        this.id = id;
        this.label = label;
    }

    public Object getCustomData() {
        return customData;
    }

    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getLabel() {
        return label;
    }

    public Uri getUri() {
        return mUri;
    }

}