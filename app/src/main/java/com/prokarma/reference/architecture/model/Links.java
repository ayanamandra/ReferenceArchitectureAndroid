package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {
    @SerializedName("first")
    @Expose
    public Link first;
    @SerializedName("self")
    @Expose
    public Link self;
    @SerializedName("next")
    @Expose
    public Link next;
    @SerializedName("last")
    @Expose
    public Link last;

    public Link getFirst() {
        return first;
    }

    public Link getSelf() {
        return self;
    }

    public Link getNext() {
        return next;
    }

    public Link getLast() {
        return last;
    }
}
