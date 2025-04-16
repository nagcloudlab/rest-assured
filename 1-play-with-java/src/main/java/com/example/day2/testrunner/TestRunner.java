package com.example.day2.testrunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) {

        int passed = 0;
        try {
            // load test-cases ( dynamic class loading )
            Class<?> clazz = Class.forName("com.example.day2.testcases.CalculatorTest");
            // instantiate test-cases
            Object testCase = clazz.getDeclaredConstructor().newInstance();
            // find test-methods
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method:methods){
                // check if method is annotated with @Test
                if(method.isAnnotationPresent(Test.class)){
                    // invoke test-method
                    method.invoke(testCase);
                    // check if test-method passed
                    // if passed increment passed counter
                    passed++;
                    // if failed increment failed counter
                    // if exception is thrown, increment failed counter
                }
            }
            // collect results
            // print results
            System.out.println("Passed: " + passed);

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
