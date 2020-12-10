package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(JSONController.class)

public class JSONControllerTest {

    @Autowired
    MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetFlight() throws Exception {
        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$.tickets.passenger.firstName", is("Some name")))
                .andExpect(jsonPath("$.tickets.passenger.lastName", is("Some other name")))
                .andExpect(jsonPath("$.tickets.price", is(200)));
    }

    @Test
    public void testGetFlights() throws Exception {
        this.mvc.perform(
                get("/flights/flights")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$[0].tickets.passenger.firstName", is("Some name")))
                .andExpect(jsonPath("$[0].tickets.passenger.lastName", is("Some other name")))
                .andExpect(jsonPath("$[0].tickets.price", is(200)))
                .andExpect(jsonPath("$[1].departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$[1].tickets.passenger.firstName", is("Some other name")))
//                .andExpect(jsonPath("$[1].tickets.passenger.lastName", is(null)))
                .andExpect(jsonPath("$[1].tickets.price", is(400)));
    }

//    @Test
//    public void testJSONFormatting() throws Exception {
//        this.mvc.perform(
//                get("/flights/flights")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].Departs", is("2017-04-21 14:34")))
//                .andExpect(jsonPath("$[0].Tickets.Passenger.FirstName", is("Some name")))
//                .andExpect(jsonPath("$[0].Tickets.Passenger.LastName", is("Some other name")))
//                .andExpect(jsonPath("$[0].Tickets.Price", is(200)))
//                .andExpect(jsonPath("$[1].Departs", is("2017-04-21 14:34")))
//                .andExpect(jsonPath("$[1].Tickets.Passenger.FirstName", is("Some other name")))
////                .andExpect(jsonPath("$[1].tickets.passenger.lastName", is(null)))
//                .andExpect(jsonPath("$[1].Tickets.Price", is(400)));
//    }

    @Test
    public void testPostForTotal() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"tickets\": [\n" +
                        "    {\n" +
                        "      \"passenger\": {\n" +
                        "        \"firstName\": \"Some name\",\n" +
                        "        \"lastName\": \"Some other name\"\n" +
                        "      },\n" +
                        "      \"price\": 200\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"passenger\": {\n" +
                        "        \"firstName\": \"Name B\",\n" +
                        "        \"lastName\": \"Name C\"\n" +
                        "      },\n" +
                        "      \"price\": 150\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("result", is(350)));
    }
}