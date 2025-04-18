package com.example.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class TransferHistoryApiTest {


    @Test
    public void getFailedTransfers() {
        given()
                .queryParam("status", "FAILED")
                .log().body()
                .when()
                .get("/api/transfer-history")// /api/transfer-history?status=FAILED
                .then()
                .statusCode(204)
                .log().body(); // To show all
    }


}
