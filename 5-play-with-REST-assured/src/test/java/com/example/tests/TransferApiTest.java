package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;


public class TransferApiTest extends BaseTransferApiTest {

    @Test
    public void sampleTest() {
        // Sample test code
        // Act ( make api call )
        // Assert ( validate response )
        // assertTrue(true);

        // core & string matchers
        assertThat("Hello World", equalTo("Hello World"));
        assertThat("Hello World", containsString("World"));
        assertThat("Hello World", startsWith("Hello"));
        assertThat("Hello World", endsWith("World"));
        assertThat("Hello World", not(equalTo("Hello")));
        assertThat("Hello World", not(containsString("Java")));

        // number matchers
        assertThat(5, equalTo(5));
        assertThat(5, greaterThan(4));
        assertThat(5, lessThan(6));
        assertThat(5, greaterThanOrEqualTo(5));
        assertThat(5, lessThanOrEqualTo(5));
        assertThat(5, not(equalTo(6)));
        assertThat(5.0, closeTo(5.1, 0.1)); // 5.1 - 0.2 = 4.9, 5.1 + 0.2 = 5.3


        // collection matchers
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), hasItem(1));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), hasItems(1, 2));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), hasSize(10));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), everyItem(greaterThan(0)));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), everyItem(lessThan(11)));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), not(hasItem(11)));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), not(hasItems(11, 12)));

        // combination matchers
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), allOf(hasItem(1), hasItem(2), hasItem(3)));
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), anyOf(hasItem(1), hasItem(11), hasItem(12)));
        // both
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), both(hasItem(1)).and(hasItem(2)));
        // either
        assertThat(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), either(hasItem(1)).or(hasItem(11)));

    }


    // Junit + Hamcrest + Rest Assured
    @Test
    public void transferMoneyTest() {

        String requestBody = """
                {
                  "fromAccount": "A001",
                  "toAccount": "A002",
                  "amount": 100.0
                }
                """;
        given()
                .spec(transferRequestSpec)
                .body(requestBody)
                .when()
                .post()
                .then()
                .spec(transferResponseSpec)
                .body("status", equalTo("SUCCESS"))
                .body("amount", equalTo(100.0f)) // for float/double use f
                .body("fromAccount", startsWith("A001"))
                .body("transferId", isValidTransferId);

    }

    Matcher<String> isValidTransferId = new TypeSafeMatcher<>() {
        public void describeTo(Description description) {
            description.appendText("a valid transfer id starting with TRX");
        }

        protected boolean matchesSafely(String id) {
            return id != null && id.startsWith("TRX") && id.length() > 5;
        }
    };


}
