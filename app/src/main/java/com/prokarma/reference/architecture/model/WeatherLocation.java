package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherLocation {
    @SerializedName("title")
    @Expose
    public String title;  //Name of the location

    @SerializedName("location_type")
    @Expose
    public String location_type; //(City|Region / State / Province|Country|Continent)

    @SerializedName("latt_long")
    @Expose
    public String latt_long;  //floats, comma separated

    @SerializedName("woeid")
    @Expose
    public int woeid;  //Where On Earth ID

    @SerializedName("distance")
    @Expose
    public int distance;  //units:Metres;  Only returned on a lattlong search


}
