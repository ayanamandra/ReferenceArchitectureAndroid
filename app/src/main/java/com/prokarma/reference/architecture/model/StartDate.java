package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartDate {
    @SerializedName("localDate")
    @Expose
    public String localDate;
    @SerializedName("localTime")
    @Expose
    public String localTime;
    @SerializedName("dateTime")
    @Expose
    public String dateTime;
    @SerializedName("dateTBD")
    @Expose
    public Boolean dateTBD;
    @SerializedName("dateTBA")
    @Expose
    public Boolean dateTBA;
    @SerializedName("timeTBA")
    @Expose
    public Boolean timeTBA;
    @SerializedName("noSpecificTime")
    @Expose
    public Boolean noSpecificTime;
}