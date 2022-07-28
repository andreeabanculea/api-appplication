package com.example.internshipproject.Controller;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {


    private JSONObject student = new JSONObject();
    private final List<Integer> evenNumbers = new ArrayList<>() {{
        for (int i = 0; i < 5; i++)
            add(i * 2);
    }};
    private final List<Integer> oddNumbers = new ArrayList<>() {{
        for (int i = 0; i < 5; i++)
            add(i * 2 + 1);
    }};


    @GetMapping("/start")
    public String welcomeClient() {
        return "Welcome!";
    }

    @GetMapping("/students")
    public JSONObject getStudent() {
        student.put("name", "Andreea");
        student.put("grade", 9);
        return student;
    }

    @GetMapping("/numbers")
    public String getNumbers(@RequestParam(name = "type",
            defaultValue = "false") boolean type) {
        if (type) {
            return evenNumbers.toString();
        }
        return oddNumbers.toString();
    }

    @PostMapping("/sum")
    public int sum(@RequestBody JSONObject list) {
        int sum = 0;
        ArrayList<Integer> numbers = (ArrayList<Integer>) list.get("list");
        for (int a : numbers)
            sum += a;
        return sum;
    }


}
