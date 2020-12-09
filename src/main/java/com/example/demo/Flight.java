package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDateTime;

public class Flight {

    public LocalDateTime departs;
    public Ticket tickets;

//    @JsonSetter("Departs")
    public void setDeparts(LocalDateTime departs) {
        this.departs = departs;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonGetter("departs")
    public LocalDateTime getDeparts() {
        return departs;
    }

//    @JsonSetter("Tickets")
    public void setTicket(Ticket tickets) {
        this.tickets = tickets;
    }

//    @JsonSetter("tickets")
    public Ticket getTicket() {
        return tickets;
    }
}