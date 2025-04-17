package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HealthCheckTest {

    static {
        RestAssured.baseURI = "http://localhost:8080"; // Adjust if needed
    }

    @Test
    @Disabled
    void testHealthEndpoint() {
        Response response = get("/actuator/health"); // or any GET endpoint
        response.prettyPrint(); // Show full JSON

        response.then()
                .statusCode(200)
                .body("status", equalTo("UP")); // for Spring Boot actuator
    }

    @Test
    void testTransferApiPost() {
        String requestBody = """
            {
              "fromAccount": "1",
              "toAccount": "2",
              "amount": 100.0
            }
            """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/transfer")
                .then()
                .statusCode(200)
                .body("status", equalTo("SUCCESS"))
                .body("amount", equalTo(100.0f));
    }
}
