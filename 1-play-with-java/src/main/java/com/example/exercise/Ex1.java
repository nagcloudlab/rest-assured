package com.example.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Ex1 {
    public static void main(String[] args) throws IOException {

        // input
//        String[] csvReport = {
//                "A,IT,1000",
//                "B,HR,2000",
//                "C,IT,3000",
//                "D,HR,4000",
//        };

        FileReader fileReader = new FileReader(new File("/home/nag/rest-assured/1-play-with-java/report.csv"));
        String[] csvReport = new String[0];
        try (BufferedReader br = new BufferedReader(fileReader)) {
            csvReport = br.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // output
        /*
            Department  | Total Salary
            IT          | 4000
            HR          | 6000
            SALES       | 0
         */
        // Note : Department name is not known in advance


        // way-1 : using for loop ( imperative approach)
        Map<String, Integer> departmentSalaryMap = new java.util.HashMap<>();
        for (String line : csvReport) {
            String[] fields = line.split(",");
            String department = fields[1];
            int salary = Integer.parseInt(fields[2]);
            //System.out.println(department + " | " + salary);
            if(departmentSalaryMap.containsKey(department)) {
                departmentSalaryMap.compute(department, (k, totalSalary) -> totalSalary + salary);
            } else {
                departmentSalaryMap.put(department, salary);
            }
        }
        System.out.println("Department | Total Salary");
        for (Map.Entry<String, Integer> entry : departmentSalaryMap.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }


        // way-2 : using stream ( declarative approach)
        //Stream<String> csvReportStream = java.util.Arrays.stream(csvReport);
        Stream<String> csvReportStream = Files.lines(Path.of("/home/nag/rest-assured/1-play-with-java/report.csv"));
        departmentSalaryMap=
        csvReportStream
                .parallel()
                .map(line -> line.split(","))
                .collect(groupingBy(fields -> fields[1], summingInt(fields -> Integer.parseInt(fields[2]))));

        System.out.println("Department | Total Salary");
        departmentSalaryMap.forEach((department, totalSalary) -> {
            System.out.println(department + " | " + totalSalary);
        });


    }
}
