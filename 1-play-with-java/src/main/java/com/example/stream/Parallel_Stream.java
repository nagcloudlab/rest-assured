package com.example.stream;

import com.example.model.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class Parallel_Stream {
    public static void main(String[] args) {


        // Parallel Stream
        // - parallelStream() : parallelize the stream
        // - parallel() : parallelize the stream
        // - sequential() : sequentialize the stream
        // - isParallel() : check if the stream is parallel
        // - forEachOrdered() : forEachOrdered() is used to maintain the order of the elements in the stream
        // - forEach() : forEach() is used to process each element in the stream in parallel

        List<Dish> menu = Dish.menu; // 9 items  e.g 9k

        menu
                .stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted((d1, d2) -> Double.compare(d1.getCalories(), d2.getCalories()))
                .parallel()
                .map(d -> d.getName())
                .forEach(System.out::println);

    }
}
