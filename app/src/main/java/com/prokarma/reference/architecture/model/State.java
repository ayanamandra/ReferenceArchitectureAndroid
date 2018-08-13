package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class State {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("stateCode")
    @Expose
    public String stateCode;
}