package com.example.tests.week2;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class TransferIdMatcher extends TypeSafeMatcher<String> {

    @Override
    protected boolean matchesSafely(String transferId) {
        return transferId.matches("TRX\\d+");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a valid transfer ID starting with TRX followed by digits");
    }

    public static TransferIdMatcher isValidTransferId() {
        return new TransferIdMatcher();
    }
}

