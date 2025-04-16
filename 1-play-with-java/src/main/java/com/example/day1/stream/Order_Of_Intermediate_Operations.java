package com.example.stream;

import java.util.List;

public class Order_Of_Intermediate_Operations {
    public static void main(String[] args) {

        List<Integer> integers=List.of(1,2,3,4,5,6,7,8,9,10);

        // 1. Create a stream
        // 2. Apply intermediate operations (filter, map, sorted, etc.)
        // 3. Apply terminal operation (collect, forEach, reduce, etc.)


        // 1. Create a stream
        integers.stream()
                .peek(n-> System.out.println("before filter: " + n)) // peek to see the elements
                // 2. Apply intermediate operations (filter, map, sorted, etc.)
                .filter(n -> n % 2 == 0) // filter even numbers
                .peek(n-> System.out.println("after filter: " + n)) // peek to see the elements
                // 3. Apply terminal operation (collect, forEach, reduce, etc.)
                .limit(3)
                .forEach(System.out::println); // print the numbers

    }
}
