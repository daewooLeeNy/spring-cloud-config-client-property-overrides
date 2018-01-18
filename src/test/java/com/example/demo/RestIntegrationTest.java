package com.example.demo;

import org.apache.http.protocol.HTTP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"foo=local"})
public class RestIntegrationTest {
    // You must prepare the configuration server before testing
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void overrideProperties() {
        ResponseEntity<Map> response = restTemplate.getForEntity("/", Map.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("local", response.getBody().get("foo"));
        assertEquals("from foo props", response.getBody().get("remote.foo"));
    }
}