package com.example.tests.week2;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpecReuseTest {

    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

    @BeforeAll
    static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/api")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer dummy-token")
                .log(LogDetail.ALL)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    void testWithSpec() {
        given()
                .spec(requestSpec)
                .when()
                .get("/transfer/sample")
                .then()
                .spec(responseSpec);
    }

    @Test
    void testWithSpec2() {
        given()
                .spec(requestSpec)
                .when()
                .get("/transfer/sample2")
                .then()
                .spec(responseSpec);
    }
}

