package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicSales {
    @SerializedName("startDateTime")
    @Expose
    public String startDateTime;
    @SerializedName("startTBD")
    @Expose
    public Boolean startTBD;
    @SerializedName("endDateTime")
    @Expose
    public String endDateTime;
}
