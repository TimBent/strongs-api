package com.timbent.strongsdataapi.url.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StrongsDataResponse {
    @JsonProperty("shortUrl")
    private String shortUrl;

    public StrongsDataResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
