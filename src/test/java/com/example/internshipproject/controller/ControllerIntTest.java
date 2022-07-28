package com.example.internshipproject.controller;

import com.example.internshipproject.Controller.Controller;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
public class ControllerIntTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void welcomeTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/start");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Welcome!", result.getResponse().getContentAsString());
    }

    @Test
    void getStudentTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/students");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("{\"grade\":9,\"name\":\"Andreea\"}", result.getResponse().getContentAsString());
    }

    @Test
    void getNumbersTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/numbers").param("type", String.valueOf(true));
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("[0, 2, 4, 6, 8]", result.getResponse().getContentAsString());


        RequestBuilder request2 = MockMvcRequestBuilders.get("/numbers").param("type", String.valueOf(false));
        MvcResult result2 = mvc.perform(request2).andReturn();
        assertEquals("[1, 3, 5, 7, 9]", result2.getResponse().getContentAsString());

    }

    @Test
    void sumTest() throws Exception {
        JSONObject obj = new JSONObject();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        obj.put("list", list);

        RequestBuilder request = MockMvcRequestBuilders.post("/sum").contentType(MediaType.APPLICATION_JSON).content(obj.toJSONString());
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("6", result.getResponse().getContentAsString());
    }
}
