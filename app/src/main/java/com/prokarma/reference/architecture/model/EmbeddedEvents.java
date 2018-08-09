package com.prokarma.reference.architecture.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmbeddedEvents {
    @SerializedName("venues")
    @Expose
    public List<Venue> venues = null;
    @SerializedName("attractions")
    @Expose
    public List<Attraction> attractions = null;
}
