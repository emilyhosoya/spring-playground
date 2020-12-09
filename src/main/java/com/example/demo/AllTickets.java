package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllTickets {
    private Price[] prices;
    private Integer total;

    @JsonProperty("tickets")
    public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }

    @JsonProperty("result")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}