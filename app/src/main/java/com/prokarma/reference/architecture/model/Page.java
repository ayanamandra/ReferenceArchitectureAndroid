package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("totalElements")
    @Expose
    public Integer totalElements;
    @SerializedName("totalPages")
    @Expose
    public Integer totalPages;
    @SerializedName("number")
    @Expose
    public Integer number;

    public Integer getSize() {
        return size;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getNumber() {
        return number;
    }
}
