package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Flight {

    public LocalDateTime departs;
    public Ticket tickets;

    public void setDeparts(LocalDateTime departs) {
        this.departs = departs;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime getDeparts() {
        return departs;
    }

    public void setTicket(Ticket tickets) {
        this.tickets = tickets;
    }

    public Ticket getTicket() {
        return tickets;
    }
}