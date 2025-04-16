package com.example.day1.stream;

import com.example.day1.model.Apple;

import java.util.*;
import java.util.stream.Collectors;

public class Terminal_Operations {
    public static void main(String[] args) {

        List<Apple> apples = List.of(
                new Apple(100, "green"),
                new Apple(200, "red"),
                new Apple(300, "green"),
                new Apple(400, "red"),
                new Apple(400, "red")
        );

        ///  Stream API : terminal operations ( making results)

        // - count
        long count = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .count();
        System.out.println("count = " + count);

        System.out.println("---------------");

        // - collect

        // - toList
        List<Apple> appleList = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.toList());
        System.out.println("appleList = " + appleList);

        System.out.println("---------------");

        // - toSet
        Set<Apple> appleSet = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.toSet());
        System.out.println("appleSet = " + appleSet);

        System.out.println("---------------");

        // - toMap
//        Map<Integer, Apple> appleMap = apples.stream()
//                .filter(apple -> apple.getWeight() > 200)
//                .collect(Collectors.toMap(Apple::getWeight, apple -> apple));
//        System.out.println("appleMap = " + appleMap);

        System.out.println("---------------");

        // - groupingBy

        Map<Integer, List<Apple>> appleMap = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.groupingBy(Apple::getWeight));
        System.out.println("appleMap = " + appleMap);

        System.out.println("---------------");

        // - partitioningBy

        Map<Boolean, List<Apple>> applePartition = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.partitioningBy(apple -> apple.getColor().equals("red")));
        System.out.println("applePartition = " + applePartition);

        System.out.println("---------------");

        // - joining

        String appleNames = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .map(apple -> apple.getColor())
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("appleNames = " + appleNames);


        // - summarizing

        // - summarizingInt
        IntSummaryStatistics intSummaryStatistics = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.summarizingInt(Apple::getWeight));
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);

        // - summarizingDouble

        DoubleSummaryStatistics doubleSummaryStatistics = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.summarizingDouble(Apple::getWeight));

        // - summarizingLong

        LongSummaryStatistics longSummaryStatistics = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .collect(Collectors.summarizingLong(Apple::getWeight));

        System.out.println("----------------");

        // - reducing

        OptionalInt totalWeight = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .mapToInt(apple->apple.getWeight())
                .reduce((a, b) -> a + b);

        System.out.println("totalWeight = " + totalWeight.orElse(0));

        System.out.println("----------------");

        //------------------
        // boolean operations
        //------------------

        // - allMatch
        boolean allMatch = apples.stream()
                .allMatch(apple -> apple.getWeight() > 200);
        System.out.println("allMatch = " + allMatch);

        // - anyMatch
        boolean anyMatch = apples.stream()
                .anyMatch(apple -> apple.getWeight() > 200);
        System.out.println("anyMatch = " + anyMatch);

        // - noneMatch
        boolean noneMatch = apples.stream()
                .noneMatch(apple -> apple.getWeight() > 200);
        System.out.println("noneMatch = " + noneMatch);

        // - findFirst : get the first element

        Optional<Apple> firstApple = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .findFirst();
        System.out.println("firstApple = " + firstApple.orElse(null));

        // - findAny : get any element

        Optional<Apple> anyApple = apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .findAny();

        System.out.println("anyApple = " + anyApple.orElse(null));

        System.out.println("---------------");

        // - forEach

        apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .forEach(System.out::println);

        System.out.println("---------------");


    }
}
