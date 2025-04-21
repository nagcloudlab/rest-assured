package com.example.tests.week2;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CustomFilterTest {

    @Test
    void testWithMaskedFilter() {
        given()
                .baseUri("http://localhost:8080/api")
                .filter(new MaskAuthFilter())
                .when()
                .get("/transfer/sample")
                .then()
                .statusCode(200);
    }

}
