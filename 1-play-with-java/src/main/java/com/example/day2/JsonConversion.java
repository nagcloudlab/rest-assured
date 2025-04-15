package com.example.day2;


import com.example.model.Apple;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConversion {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // java object to json
//        Apple apple = new Apple(100, "red");
//        String json=mapper.writeValueAsString(apple);
//        System.out.println(json);
//
//        // json to java object
//
//        String jsonString = """
//                {
//                "weight": 100,
//                "color": "red"
//                }
//                """;
//
//        Apple apple1 = mapper.readValue(jsonString, Apple.class);
//        System.out.println(apple1);

        // java-object to json-file
        Apple apple = new Apple(100, "red");
        mapper.writeValue(new File("apple.json"), apple);
        System.out.println("Json file created");


        // json-file to java-object
        Apple apple2 = mapper.readValue(new File("apple.json"), Apple.class);
        System.out.println(apple2);


    }
}
