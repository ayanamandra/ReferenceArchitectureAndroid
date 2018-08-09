package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dates {
    @SerializedName("start")
    @Expose
    public StartDate start;
    @SerializedName("status")
    @Expose
    public Status status;
    @SerializedName("spanMultipleDays")
    @Expose
    public Boolean spanMultipleDays;
    @SerializedName("timezone")
    @Expose
    public String timezone;
}
