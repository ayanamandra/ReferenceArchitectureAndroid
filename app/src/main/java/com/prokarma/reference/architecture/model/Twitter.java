package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Twitter {
    @SerializedName("handle")
    @Expose
    public String handle;
}