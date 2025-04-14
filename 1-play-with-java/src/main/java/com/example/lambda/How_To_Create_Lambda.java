package com.example.lambda;


import java.util.function.*;
import java.util.function.Predicate;

/*
How to create Lambda Expressions in Java?
 */
interface MyFunctionalInterface {
    void myMethod(); // sam ( single abstract method)
}

public class Ex2 {

    public static void main(String[] args) {

        Predicate<String> predicate = (s) -> s.length() > 5;
        Consumer<String> consumer = (s) -> System.out.println(s);
        Supplier<String> supplier = () -> "Hello World";
        Function<String,String> function = (s) -> s.toUpperCase();

        BiPredicate<String,String> biPredicate = (s1,s2) -> s1.length() > s2.length();
        BiConsumer<String,String> biConsumer = (s1,s2) -> System.out.println(s1 + " " + s2);
        BiFunction<Integer,Integer,Integer> biFunction= (i1,i2) -> i1 + i2;

        UnaryOperator<String> unaryOperator = (s) -> s.toUpperCase();
        BinaryOperator<Integer> binaryOperator= (i1,i2) -> i1 + i2;

        Predicate<Integer> integerPredicate = (i) -> i > 5;
        IntPredicate intPredicate = (i) -> i > 5;

        //....

        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Hello World");
        myFunctionalInterface.myMethod();

    }

}
