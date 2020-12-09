package com.example.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Passenger {
    public String firstName;
    public String lastName;

//    @JsonSetter("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    @JsonGetter("firstName")
    public String getFirstName() {
        return firstName;
    }

//    @JsonSetter("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @JsonGetter("lastName")
    public String getLastName() {
        return lastName;
    }
}
