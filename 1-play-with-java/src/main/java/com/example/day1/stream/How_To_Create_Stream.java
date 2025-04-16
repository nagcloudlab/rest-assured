package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class How_To_Create_Stream {
    public static void main(String[] args) {

        // How to create a stream?

        // way-1 : form data elements
        // -> using Stream.of()
        Stream<String> stream1 = Stream.of("a", "b", "c", "d");

        // way-2 : from array
        // -> using Arrays.stream()

        String[] array = {"a", "b", "c", "d"};
        Stream<String> stream2 = Stream.of(array);
        // or
        Stream<String> stream3 = Arrays.stream(array);

        // way-3 : from collection
        // -> using collection.stream()
        // -> using collection.parallelStream()
        List<String> list = List.of("a", "b", "c", "d");
        Stream<String> stream4 = list.stream();

        // way-4 : from file
        // -> using Files.lines()
        // -> using Files.list()
        // later..

        // way-5 : from generator
        // -> using Stream.generate()
        Stream<String> stream5 = Stream.generate(() -> "a").limit(10);

        // way-6 : from iterate
        // -> using Stream.iterate()
        Stream<Integer> stream6 = Stream.iterate(0, n -> n + 1).limit(10);

        //...

    }
}
