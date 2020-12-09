package com.example.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket {
    public Integer price;
    public Passenger passenger;

//    @JsonSetter("Price")
    public void setPrice(Integer price) {
        this.price = price;
    }

//    @JsonGetter("price")
    public Integer getPrice() {
        return price;
    }

//    @JsonSetter("Passenger")
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

//    @JsonGetter("passenger")
    public Passenger getPassenger() {
        return passenger;
    }
}
