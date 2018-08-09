package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralInfo {
    @SerializedName("generalRule")
    @Expose
    public String generalRule;
    @SerializedName("childRule")
    @Expose
    public String childRule;
}