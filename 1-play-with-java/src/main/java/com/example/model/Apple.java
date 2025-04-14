package com.example.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Apple implements Comparable<Apple>{
    
    private int weight;
    private String color;

    @Override
    public int compareTo(Apple o) {
        return Integer.compare(this.weight, o.weight);
    }

}
