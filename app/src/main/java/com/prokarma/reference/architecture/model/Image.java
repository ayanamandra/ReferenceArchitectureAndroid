package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("ratio")
    @Expose
    public String ratio;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("fallback")
    @Expose
    public Boolean fallback;
    @SerializedName("attribution")
    @Expose
    public String attribution;
}
