package com.example.demo;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/flights")
public class JSONController {

    @GetMapping("/flight")
    public Flight getFlight() {
        Passenger passenger = new Passenger();
        Ticket tickets = new Ticket();
        Flight flight = new Flight();
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        tickets.setPassenger(passenger);
        tickets.setPrice(200);
        flight.setDeparts(LocalDateTime.of(2017, Month.APRIL, 21, 14,34));
        flight.setTicket(tickets);

        System.out.println(flight);

        return flight;
    }

}
