package com.example.model;

public class Apple implements Comparable<Apple>{
    int weight;
    String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return  "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Apple apple = (Apple) obj;
        return weight == apple.weight && color.equals(apple.color);
    }
    @Override
    public int hashCode() {
        return 31 * weight + color.hashCode();
    }

    @Override
    public int compareTo(Apple o) {
        return Integer.compare(this.weight, o.weight);
    }

}
