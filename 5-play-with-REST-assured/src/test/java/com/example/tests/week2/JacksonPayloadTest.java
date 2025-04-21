package com.example.tests.week2;


import com.example.tests.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JacksonPayloadTest {

    @Test
    void testSerializeUserWithJackson() throws Exception {
        User user = new User("Alice", "alice@example.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        given()
                .baseUri("http://localhost:8080/api/users")
                .contentType("application/json")
                .body(json)
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}

