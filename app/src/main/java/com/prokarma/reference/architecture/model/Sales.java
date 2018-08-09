package com.prokarma.reference.architecture.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sales {
    @SerializedName("public")
    @Expose
    public PublicSales publicSales;
    @SerializedName("presales")
    @Expose
    public List<Presale> presales = null;
}
