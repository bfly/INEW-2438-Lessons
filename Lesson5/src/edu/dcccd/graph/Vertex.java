package edu.dcccd.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertex implements Comparable<Vertex>{
    private String name;

    @Override
    public int compareTo(Vertex v) {
        return this.getName().compareTo(v.getName());
    }
}