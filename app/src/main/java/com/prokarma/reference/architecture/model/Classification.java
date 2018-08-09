package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Classification {
    @SerializedName("primary")
    @Expose
    public Boolean primary;
    @SerializedName("segment")
    @Expose
    public Segment segment;
    @SerializedName("genre")
    @Expose
    public Genre genre;
    @SerializedName("subGenre")
    @Expose
    public Genre subGenre;
    @SerializedName("family")
    @Expose
    public Boolean family;
    @SerializedName("type")
    @Expose
    public Type type;
    @SerializedName("subType")
    @Expose
    public Type subType;
}
