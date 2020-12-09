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

        return flight;
    }

    @GetMapping("/flights")
    public List getFlights() {
        List flightList = new ArrayList<>();

        Passenger passenger = new Passenger();
        passenger.setFirstName("Some name");
        passenger.setLastName("Some other name");
        Ticket tickets = new Ticket();
        tickets.setPrice(200);
        tickets.setPassenger(passenger);
        Flight flight = new Flight();
        flight.setDeparts(LocalDateTime.of(2017, Month.APRIL, 21, 14,34));
        flight.setTicket(tickets);

        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Some other name");
        passenger2.setLastName(null);
        Ticket tickets2 = new Ticket();
        tickets2.setPrice(400);
        tickets2.setPassenger(passenger2);
        Flight flight2 = new Flight();
        flight2.setDeparts(LocalDateTime.of(2017, Month.APRIL, 21, 14,34));
        flight2.setTicket(tickets2);

        flightList.add(flight);
        flightList.add(flight2);
        System.out.println(flightList);
        return flightList;
    }

}
