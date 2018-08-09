package com.prokarma.reference.architecture.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attraction {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("test")
    @Expose
    public Boolean test;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("locale")
    @Expose
    public String locale;
    @SerializedName("externalLinks")
    @Expose
    public LinkExternal externalLinks;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("classifications")
    @Expose
    public List<Classification> classifications = null;
    @SerializedName("upcomingEvents")
    @Expose
    public UpcomingEvents upcomingEvents;
    @SerializedName("_links")
    @Expose
    public LinkAttraction links;
}