package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Presale {
    @SerializedName("startDateTime")
    @Expose
    public String startDateTime;
    @SerializedName("endDateTime")
    @Expose
    public String endDateTime;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("url")
    @Expose
    public String url;
}
