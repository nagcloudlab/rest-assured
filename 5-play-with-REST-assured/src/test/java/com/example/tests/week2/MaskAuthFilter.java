package com.example.tests.week2;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class MaskAuthFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext filterContext) {
        if (requestSpec.getHeaders().hasHeaderWithName("Authorization")) {
            requestSpec.removeHeader ("Authorization");
            requestSpec.header("Authorization", "**** MASKED ****");
        }
        return filterContext.next(requestSpec, responseSpec); // Proceed with the request
    }
}
