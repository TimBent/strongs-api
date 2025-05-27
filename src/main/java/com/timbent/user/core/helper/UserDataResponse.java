package com.timbent.user.core.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDataResponse {
    @JsonProperty("shortUrl")
    private String shortUrl;

    public UserDataResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
