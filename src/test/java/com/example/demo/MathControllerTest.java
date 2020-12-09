package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathController.class)

public class MathControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testGetPi() throws Exception {
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

//    @Test
//    public void testPostSum() throws Exception {
//        RequestBuilder request = post("/math/sum?n=4&n=5&n=6");
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("4 + 5 + 6 = 15"));
//    }

    @Test
    public void testPostVolume() throws Exception {
        int length = 3, width = 4, height = 5;
        RequestBuilder request = post(String.format("/math/volume/%d/%d/%d", length, width, height));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testPatchVolume() throws Exception {
        int length = 6, width = 7, height = 8;
        RequestBuilder request = patch(String.format("/math/volume/%d/%d/%d", length, width, height));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }

//    @Test
//    public void testCircleArea() throws Exception {
//        String type = "circle";
//        String radius = "4";
//
//        MockHttpServletRequestBuilder request = post("/math/area")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("type", type)
//                .param("radius", radius);
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));
//    }
//
//    @Test
//    public void testRectangleArea() throws Exception {
//        String type = "rectangle";
//        String width = "4";
//        String height = "7";
//
//        MockHttpServletRequestBuilder request = post("/math/area")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("type", type)
//                .param("width", width)
//                .param("height", height);
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("Area of a 4x7 rectangle is 28"));
//    }
//
//    @Test
//    public void testAreaInvalid() throws Exception {
//        String type = "rectangle";
//        String radius = "5";
//
//        MockHttpServletRequestBuilder request = post("/math/area")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("type", type)
//                .param("radius", radius);
//
//        this.mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("Invalid"));
//    }
}
