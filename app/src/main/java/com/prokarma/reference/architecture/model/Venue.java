package com.prokarma.reference.architecture.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

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
    @SerializedName("postalCode")
    @Expose
    public String postalCode;
    @SerializedName("timezone")
    @Expose
    public String timezone;
    @SerializedName("city")
    @Expose
    public City city;
    @SerializedName("state")
    @Expose
    public State state;
    @SerializedName("country")
    @Expose
    public Country country;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("markets")
    @Expose
    public List<Market> markets = null;
    @SerializedName("dmas")
    @Expose
    public List<Dma> dmas = null;
    @SerializedName("boxOfficeInfo")
    @Expose
    public BoxOfficeInfo boxOfficeInfo;
    @SerializedName("parkingDetail")
    @Expose
    public String parkingDetail;
    @SerializedName("accessibleSeatingDetail")
    @Expose
    public String accessibleSeatingDetail;
    @SerializedName("generalInfo")
    @Expose
    public GeneralInfo generalInfo;
    @SerializedName("upcomingEvents")
    @Expose
    public UpcomingEvents upcomingEvents;
    @SerializedName("_links")
    @Expose
    public LinkVenue links;
    @SerializedName("social")
    @Expose
    public Social social;
}