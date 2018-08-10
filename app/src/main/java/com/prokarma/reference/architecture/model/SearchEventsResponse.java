package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchEventsResponse {
    @SerializedName("_embedded")
    @Expose
    public Embedded embedded;
    @SerializedName("_links")
    @Expose
    public Links links;
    @SerializedName("page")
    @Expose
    public Page page;

    public Embedded getEmbedded() {
        return embedded;
    }

    public Links getLinks() {
        return links;
    }

    public Page getPage() {
        return page;
    }
}
