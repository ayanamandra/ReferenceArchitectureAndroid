package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("countryCode")
    @Expose
    public String countryCode;
}