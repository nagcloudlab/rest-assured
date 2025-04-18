package com.example.tests;

import com.example.tests.dto.TransferRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class DataDrivenTransferApiTest extends BaseTransferApiTest {


    @ParameterizedTest
    @CsvFileSource(files = "/home/nag/rest-assured/5-play-with-REST-assured/transfer-test-data.csv", numLinesToSkip = 1)
    public void transferMoneyTestCsvDataSource(String fromAccount, String toAccount, float amount) {

        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setFromAccount(fromAccount);
        transferRequest.setToAccount(toAccount);
        transferRequest.setAmount(amount);

        // Create a request body as a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writeValueAsString(transferRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        given()
                .spec(transferRequestSpec)
                .body(requestBody)
                .when()
                .post()
                .then()
                .spec(transferResponseSpec)
                .body("status", equalTo("SUCCESS"))
                .body("amount", equalTo(amount)) // for float/double use f
                .body("fromAccount", startsWith(fromAccount))
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


    @ParameterizedTest
    @MethodSource("getTransferDataFromExcel")
    public void transferMoneyTestExcelDataSource(String fromAccount, String toAccount, float amount) {

        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setFromAccount(fromAccount);
        transferRequest.setToAccount(toAccount);
        transferRequest.setAmount(amount);

        // Create a request body as a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writeValueAsString(transferRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        given()
                .spec(transferRequestSpec)
                .body(requestBody)
                .when()
                .post()
                .then()
                .spec(transferResponseSpec)
                .body("status", equalTo("SUCCESS"))
                .body("amount", equalTo(amount)) // for float/double use f
                .body("fromAccount", startsWith(fromAccount))
                .body("transferId", isValidTransferId);

    }


    private static Stream<Arguments> getTransferDataFromExcel() throws Exception {
        FileInputStream file = new FileInputStream("/home/nag/rest-assured/5-play-with-REST-assured/transfer-test-data.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<Arguments> argumentsList = new java.util.ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header
            String fromAccount = row.getCell(0).getStringCellValue();
            String toAccount = row.getCell(1).getStringCellValue();
            double amount = row.getCell(2).getNumericCellValue();
            argumentsList.add(Arguments.of(fromAccount, toAccount, (float) amount));
        }
        workbook.close();
        return argumentsList.stream();
    }


}
