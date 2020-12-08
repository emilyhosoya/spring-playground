package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathController.class)

public class MathControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testPi() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(Math.PI)));
    }

    @Test
    public void testAdd() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testMultiply() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    public void testSubtract() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=4&y=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testDivide() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testNoOperand() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("30 + 5 = 35"));
    }
}
