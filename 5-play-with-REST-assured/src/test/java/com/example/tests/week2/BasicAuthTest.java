package com.example.tests.week2;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BasicAuthTest {

    @Test
    void testWithBasicAuth() {
        given()
                .baseUri("http://localhost:8080/api")
                .auth().basic("admin", "password123")
                .log().all()
                .when()
                .get("/secure/accounts")
                .then()
                .statusCode(404);
    }

}
