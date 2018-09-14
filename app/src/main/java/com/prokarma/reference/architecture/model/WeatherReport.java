package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherReport {
    @SerializedName("id")
    @Expose
    public String id;  //Internal identifier for the forecast

    @SerializedName("applicable_date")
    @Expose
    public String applicable_date;  //Date that the forecast or observation pertains to

    @SerializedName("weather_state_name")
    @Expose
    public String weather_state_name;  //Text description of the weather state

    @SerializedName("weather_state_abbr")
    @Expose
    public String weather_state_abbr;  //One or two letter abbreviation of the weather state

    @SerializedName("wind_speed")
    @Expose
    public float wind_speed;  //units: mph

    @SerializedName("wind_direction")
    @Expose
    public float wind_direction;  //units: degrees

    @SerializedName("wind_direction_compass")
    @Expose
    public String wind_direction_compass;  //units: compass point.  Compass point of the wind direction

    @SerializedName("min_temp")
    @Expose
    public float min_temp;  //units: centigrade

    @SerializedName("max_temp")
    @Expose
    public float max_temp;  //units: centigrade

    @SerializedName("the_temp")
    @Expose
    public float the_temp;  //units: centigrade

    @SerializedName("air_pressure")
    @Expose
    public float air_pressure;  //units: mbar

    @SerializedName("humidity")
    @Expose
    public float humidity;  //units: percentage

    @SerializedName("visibility")
    @Expose
    public float visibility;  //units: miles

    @SerializedName("predictability")
    @Expose
    public float predictability;  //units: percentage.  Our interpretation of the level to which the forecasters agree with each other - 100% being a complete consensus.


}
