package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceRange {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("min")
    @Expose
    public Double min;
    @SerializedName("max")
    @Expose
    public Double max;
}