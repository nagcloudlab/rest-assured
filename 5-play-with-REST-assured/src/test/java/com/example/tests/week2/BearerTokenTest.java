package com.example.tests.week2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BearerTokenTest {

    @Test
    void testWithBearerToken() {
        // Step 1: Login to get token
        String token = given()
                .baseUri("http://localhost:8080/api")
                .contentType("application/json")
                .body("""
                        {
                          "username": "testuser",
                          "password": "pass123"
                        }
                        """)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token"); // JWT token extraction

        // Step 2: Use token in Authorization header
        given()
                .baseUri("http://localhost:8080/api")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/secure/profile")
                .then()
                .statusCode(200);
    }
}