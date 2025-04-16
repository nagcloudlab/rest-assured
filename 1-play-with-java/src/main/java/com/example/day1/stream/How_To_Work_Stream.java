package com.example.stream;

import java.util.stream.Stream;

public class How_To_Work_Stream {


    public static void main(String[] args) {

        // 1. Create a stream
        // 2. Apply intermediate operations (filter, map, sorted, etc.)
        // 3. Apply terminal operation (collect, forEach, reduce, etc.)
        // 4. Close the stream (optional)


        Stream<Integer> integerStream=Stream.iterate(0, n -> n + 1); // create a stream of integers starting from 0
        integerStream
                .filter(n-> n%2==0) // intermediate operation
                .limit(10) // intermediate operation
                .forEach(n-> System.out.println("Number: "+n)); // terminal operation

        integerStream=Stream.iterate(0, n -> n + 1);
        Stream<Integer> integerStreamWithLimit=integerStream
                .filter(n-> n%2!=0) // intermediate operation
                .limit(10); // intermediate operation
               // .forEach(n-> System.out.println("Number: "+n)); // terminal operation
         integerStreamWithLimit.forEach(n-> System.out.println("Number: "+n)); // terminal operation
    }

}
