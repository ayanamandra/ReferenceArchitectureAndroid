package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Outlet {
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("type")
    @Expose
    public String type;
}