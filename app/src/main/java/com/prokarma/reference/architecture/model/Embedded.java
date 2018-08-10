package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Embedded {
    @SerializedName("events")
    @Expose
    public List<Event> events = null;

    public List<Event> getEvents() {
        return events;
    }
}
