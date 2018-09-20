package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Event implements Serializable{

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
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("sales")
    @Expose
    public Sales sales;
    @SerializedName("dates")
    @Expose
    public Dates dates;
    @SerializedName("classifications")
    @Expose
    public List<Classification> classifications = null;
    @SerializedName("promoter")
    @Expose
    public Promoter promoter;
    @SerializedName("promoters")
    @Expose
    public List<Promoter> promoters = null;
    @SerializedName("outlets")
    @Expose
    public List<Outlet> outlets = null;
    @SerializedName("seatmap")
    @Expose
    public Seatmap seatmap;
    @SerializedName("_links")
    @Expose
    public Links links;
    @SerializedName("_embedded")
    @Expose
    public EmbeddedEvents embedded;
    @SerializedName("priceRanges")
    @Expose
    public List<PriceRange> priceRanges = null;
    @SerializedName("ticketLimit")
    @Expose
    public TicketLimit ticketLimit;
}
