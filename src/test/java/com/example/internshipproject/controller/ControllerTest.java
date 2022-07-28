package com.example.internshipproject.controller;

import com.example.internshipproject.Controller.Controller;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    Controller controller = new Controller();

    @Test
    public void welcomeTest() {

        String response = controller.welcomeClient();
        assertEquals("Welcome!", response);
    }

    @Test
    public void getStudent() {

        String response = String.valueOf(controller.getStudent());
        assertEquals("{\"grade\":9,\"name\":\"Andreea\"}", response);
    }

    @Test
    public void getNumbersTest() {

        String response = controller.getNumbers(true);
        assertEquals("[0, 2, 4, 6, 8]", response);

        String response2 = controller.getNumbers(false);
        assertEquals("[1, 3, 5, 7, 9]", response2);
    }

    @Test
    public void sumTest() {
        JSONObject obj = new JSONObject();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        obj.put("list", list);
        String response = String.valueOf(controller.sum(obj));
        assertEquals("6", response);
    }


}
