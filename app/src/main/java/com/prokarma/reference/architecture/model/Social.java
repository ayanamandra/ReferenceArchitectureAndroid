package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Social {
    @SerializedName("twitter")
    @Expose
    public Twitter twitter;
}