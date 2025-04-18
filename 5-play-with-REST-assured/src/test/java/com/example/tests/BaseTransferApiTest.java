package com.example.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTransferApiTest {

    protected static RequestSpecification transferRequestSpec;
    protected static ResponseSpecification transferResponseSpec;

    private static String baseURI;
    private static int port;

    @BeforeAll
    public static void setupSpecs() {
        baseURI = "http://localhost";
        port = 8080;

        transferRequestSpec = new RequestSpecBuilder()
                .setBasePath("/api/transfer")
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .build();

        transferResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .log(LogDetail.ALL)
                .build();
    }

}
