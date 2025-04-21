package com.example.tests.week2;


import com.example.tests.dto.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GsonTest {
    @Test
    void testWithGson() {
        User user = new User("Bob", "bob@example.com");
        String json = new Gson().toJson(user);

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
