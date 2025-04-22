package com.example.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.dao.User;
import com.example.dao.UserDao;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class UseApiTest {

    UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
    }

    @Test
    void createUser() {
        
        
        ValidatableResponse validatableResponse= given()
        .contentType(ContentType.JSON)
        .body("{ \"name\": \"ashwini\", \"email\": \"ashwini@mail.com\", \"mobile\": null }")
        .when()
        .post("http://localhost:8080/api/users")
        .then()
        .statusCode(201);

        // extract userId from the response
        Integer userId = validatableResponse.extract().path("id");
        System.out.println("User ID: " + userId);
        // fetch the user from the database
        User databaseUser=userDao.getUserById(userId);

        // verify the user details
        assertThat(databaseUser.getName(), equalTo("ashwini"));
        assertThat(databaseUser.getEmail(), equalTo("ashwini@mail.com"));
        assertThat(databaseUser.getMobile(), nullValue());


    }
    
}
