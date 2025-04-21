package com.example.tests.week2;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DynamicDataTest {

    Faker faker = new Faker();

    @Test
    void testWithFakerPayload() {
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();

        String json = String.format("""
                {
                    "name": "%s",
                    "email": "%s"
                }
                """, name, email);

        given()
                .baseUri("http://localhost:8080/api/users")
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}

