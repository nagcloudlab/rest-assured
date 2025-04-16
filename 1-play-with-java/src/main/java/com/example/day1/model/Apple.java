package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Apple implements Comparable<Apple>, Serializable {

    private static final long serialVersionUID = 135434534535546345L;

    @JsonIgnore
    private int weight;
    private transient String color;

    @Override
    public int compareTo(Apple o) {
        return Integer.compare(this.weight, o.weight);
    }

}
