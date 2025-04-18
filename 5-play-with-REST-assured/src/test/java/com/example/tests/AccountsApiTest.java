package com.example.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AccountsApiTest {


    // POST
    @Test
    void testTransferMoney_Success() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"fromAccount\": \"1\", \"toAccount\": \"2\", \"amount\": 100.0 }")
                .when()
                .post("/api/transfer")
                .then()
                .statusCode(200)
                .body("status", equalTo("SUCCESS"))
                .body("amount", equalTo(100.0f))
                .body("fromAccount", equalTo("1"))
                .body("toAccount", equalTo("2"));
    }


    // POST - create new account

    @Test
    void testCreateAccount() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"number\": \"11\", \"balance\": 1000.0 }")
                .when()
                .post("/api/accounts")
                .then()
                .statusCode(201)
                .header("Location", containsString("/api/accounts/11"))
                .body("number", equalTo("11"))
                .body("balance", equalTo(1000.0f));
    }


    // GET with path parameter ( to identify the account)
    @Test
    void testGetAccountDetails() {
        given()
                .pathParam("accountNumber", "1")
                .when()
                .get("/api/accounts/{accountNumber}")
                .then()
                .statusCode(200)
                .body("number", equalTo("1"))
                .body("balance", greaterThanOrEqualTo(0.0f));
    }

    @Test
    void testGetAccountDetailsNotExist() {
        given()
                .pathParam("accountNumber", "111")
                .when()
                .get("/api/accounts/{accountNumber}")
                .then()
                .statusCode(404)
                .body("message", containsString("not found: " + 111));
    }


    // PUT
    @Test
    void testUpdateAccount() {
        given()
                .pathParam("id", "2")
                .contentType(ContentType.JSON)
                .body("{\"balance\": 500.0 }")
                .when()
                .put("/api/accounts/{id}")
                .then()
                .statusCode(200)
                .body("balance", equalTo(500.0f));
    }

    // DELETE
    @Test
    void testDeleteAccount() {
        given()
                .pathParam("id", "2")
                .when()
                .delete("/api/accounts/{id}")
                .then()
                .statusCode(anyOf(is(200), is(204))); // Either 200 OK or 204 No Content
    }


}
