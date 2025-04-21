package com.example.tests.week2;

import org.junit.jupiter.api.Test;

import static com.example.tests.week2.TransferIdMatcher.isValidTransferId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;

public class CustomMatcherTest {

    @Test
    void customMatcherTest() {
        String transferId = "TRX1234567890";
        assertThat(transferId, isValidTransferId());
    }

    @Test
    void allAccountsHavePositiveBalance() {
        given()
                .baseUri("http://localhost:8080")
                .get("/api/accounts")
                .then()
                .statusCode(200)
                .body("balance", everyItem(greaterThan(0.0f)));
    }




}
