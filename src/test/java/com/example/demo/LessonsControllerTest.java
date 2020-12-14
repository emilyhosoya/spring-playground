package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Juggling\", \"delivered_on\": \"2020-12-10\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class) ));
    }

    @Test
    @Transactional
    @Rollback
    public void testListAll() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Juggling");
        lesson.setDeliveredOn(new Date(2020,12,10));
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(lesson.getId().intValue()) ));
    }

    @Test
    @Transactional
    @Rollback
    public void testGetOne() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Juggling");
        lesson.setDeliveredOn(new Date(2020,12,10));
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class) ));
    }
//    @Test
//    @Transactional
//    @Rollback
//    public void testDelete() throws Exception {
//        Lesson lesson = new Lesson();
//        lesson.setTitle("Juggling");
//        lesson.setDeliveredOn(new Date(2020,12,10));
//        repository.save(lesson);
//
//        MockHttpServletRequestBuilder request = delete("/lessons/1")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk());
////            .andExpect(jsonPath("$.id", instanceOf(Number.class) ));
//    }

    @Test
    @Transactional
    @Rollback
    public void testPatch() throws Exception {
        MockHttpServletRequestBuilder request = patch("/lessons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Spring Security\", \"deliveredOn\": \"2017-04-12\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.title", equalTo("Spring Security")))
                .andExpect(jsonPath("$.deliveredOn", equalTo("2017-04-12")));
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByTitle() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Juggling");
        lesson.setDeliveredOn(new Date(2020,12,10));
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/find/Juggling")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Juggling")));
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByDates() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("Dependency Injection");
        lesson.setDeliveredOn(new Date(2014,02,17));
        repository.save(lesson);

        Lesson lesson2 = new Lesson();
        lesson2.setTitle("Transactions");
        lesson2.setDeliveredOn(new Date(2015,02,17));
        repository.save(lesson2);

        Lesson lesson3 = new Lesson();
        lesson3.setTitle("Underwater Basket Weaving");
        lesson3.setDeliveredOn(new Date(2020,11,10));
        repository.save(lesson3);

        MockHttpServletRequestBuilder request = get("/lessons/between?date1=2014-01-01&date2=2017-12-31")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$[0].title", equalTo("Dependency Injection")))
//                .andExpect(jsonPath("$[1].title", equalTo("Transactions")));
    }

}