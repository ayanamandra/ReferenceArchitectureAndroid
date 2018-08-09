package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("latitude")
    @Expose
    public String latitude;
}