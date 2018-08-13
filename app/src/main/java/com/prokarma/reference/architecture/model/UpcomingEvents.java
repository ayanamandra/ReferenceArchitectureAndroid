package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpcomingEvents {
    @SerializedName("_total")
    @Expose
    public Integer total;
    @SerializedName("tmr")
    @Expose
    public Integer tmr;
    @SerializedName("ticketmaster")
    @Expose
    public Integer ticketmaster;
}