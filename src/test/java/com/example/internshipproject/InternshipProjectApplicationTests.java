package com.example.internshipproject;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InternshipProjectApplicationTests {

    @Test
    void contextLoads() throws IOException {
        URL url = new URL("http://localhost:8080/start");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        assertEquals(200, responseCode);

    }



}
