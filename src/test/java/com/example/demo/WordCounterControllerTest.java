package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

//@WebMvcTest(WordCounterController.class)

@SpringBootTest
@AutoConfigureMockMvc
public class WordCounterControllerTest {

    @MockBean
    WordCounter wordCounter;

    @BeforeEach
    public void setup() {
        when(wordCounter.getWords()).thenReturn("");
    }

//    @Test
//    public void testMockWordCounter() {
//        assertThat(wordCounter.getWords(), equalTo(""));
//    }
}
