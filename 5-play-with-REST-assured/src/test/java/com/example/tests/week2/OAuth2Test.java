package com.example.tests.week2;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class OAuth2Test {

    @Test
    void testWithOAuth2Token() {
        given()
                .baseUri("http://localhost:8080/api")
                .auth().oauth2("mocked-oauth2-token")
                .when()
                .get("/secure/data")
                .then()
                .statusCode(200);
    }
}
