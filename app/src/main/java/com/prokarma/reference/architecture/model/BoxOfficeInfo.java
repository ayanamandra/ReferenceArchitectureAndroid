package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoxOfficeInfo {
    @SerializedName("phoneNumberDetail")
    @Expose
    public String phoneNumberDetail;
    @SerializedName("openHoursDetail")
    @Expose
    public String openHoursDetail;
    @SerializedName("acceptedPaymentDetail")
    @Expose
    public String acceptedPaymentDetail;
    @SerializedName("willCallDetail")
    @Expose
    public String willCallDetail;
}