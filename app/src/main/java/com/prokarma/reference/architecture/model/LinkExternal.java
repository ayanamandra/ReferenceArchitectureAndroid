package com.prokarma.reference.architecture.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinkExternal {
    @SerializedName("youtube")
    @Expose
    public List<LinkGeneric> youtube = null;
    @SerializedName("twitter")
    @Expose
    public List<LinkGeneric> twitter = null;
    @SerializedName("lastfm")
    @Expose
    public List<LinkGeneric> lastfm = null;
    @SerializedName("wiki")
    @Expose
    public List<LinkGeneric> wiki = null;
    @SerializedName("facebook")
    @Expose
    public List<LinkGeneric> facebook = null;
    @SerializedName("musicbrainz")
    @Expose
    public List<LinkMusicBrainz> musicbrainz = null;
    @SerializedName("homepage")
    @Expose
    public List<LinkGeneric> homepage = null;
}
