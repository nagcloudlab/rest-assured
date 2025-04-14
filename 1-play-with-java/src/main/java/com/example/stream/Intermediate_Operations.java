package com.example.stream;

import com.example.model.Apple;

import java.util.List;

public class Intermediate_Operations {
    public static void main(String[] args) {

        List<Apple> apples = List.of(
               new Apple(100, "green"),
                new Apple(200, "red"),
                new Apple(300, "green"),
                new Apple(400, "red"),
                new Apple(400, "red")
        );

        //--------------------------
        // filtering operations
        //---------------------------
        // - by content
        apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .forEach(System.out::println);
        System.out.println("-----------------");
        apples.stream()
                .takeWhile(apple -> apple.getWeight() > 200)
                .forEach(System.out::println);
        System.out.println("-----------------");
        apples.stream()
                .dropWhile(apple -> apple.getWeight() > 200)
                .forEach(System.out::println);
        System.out.println("-----------------");
        // - by amount
        apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("-----------------");
        // - by distinct
        apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .distinct()
                .forEach(System.out::println);
        System.out.println("-----------------");

        // - by skipping
        apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .skip(2)
                .forEach(System.out::println);

        System.out.println("-----------------");

        //---------------------
        // mapping / transform operations
        //---------------------

        // - by mapping
        apples.stream()
                .map(apple -> apple.getWeight())
                .forEach(System.out::println);

        System.out.println("-----------------");

        // - by flat mapping

        apples.stream()
                .flatMap(apple -> List.of(apple.getWeight(), apple.getWeight() + 100).stream())
                .forEach(System.out::println);

        System.out.println("-----------------");

        String[] menu={
                "idly,dosa,vada",
                "rice,sambhar,rasam",
                "curd,buttermilk,butter",
                "ice cream"
        };

        // - by flat mapping
        List.of(menu)
                .stream()
                //.map(item->item.toUpperCase())
                .flatMap(item->List.of(item.split(",")).stream())
                .map(item->item.toUpperCase())
                .forEach(System.out::println);


        System.out.println("-----------------");

        // ---------------------
        // sorting operations
        // ---------------------

        apples.stream()
                //.sorted()
                .sorted((a1, a2) -> a2.getWeight() - a1.getWeight())
                .forEach(System.out::println);

        System.out.println("-----------------");


        // ---------------------
        // peek operations
        // ---------------------

        apples.stream()
                .peek(apple -> System.out.println("before filter: " + apple))
                .filter(apple -> apple.getWeight() > 200)
                .peek(apple -> System.out.println("after filter: " + apple))
                .forEach(System.out::println);


        System.out.println("-----------------");

        // ---------------------
        // chaining operations
        // ---------------------

        apples.stream()
                .filter(apple -> apple.getWeight() > 200)
                .map(apple -> apple.getWeight())
                .sorted((a1, a2) -> a2 - a1)
                .distinct()
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-----------------");



    }
}
