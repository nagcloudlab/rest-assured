package com.example.tests.week2;


import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidationTest {

    @Test
    void validateTransferResponseSchema() {
        given()
                .baseUri("http://localhost:8080")
                .basePath("/api/transfer")
                .contentType("application/json")
                .body("""
                        {
                          "fromAccount": "A001",
                          "toAccount": "A002",
                          "amount": 100
                        }
                        """)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/transfer-response-schema.json"));
    }
}

