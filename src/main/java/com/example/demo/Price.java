package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
    private Integer price;

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}