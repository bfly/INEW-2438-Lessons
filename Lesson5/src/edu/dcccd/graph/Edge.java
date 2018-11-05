package edu.dcccd.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    private String id;
    private Vertex source;
    private Vertex destination;
    private int weight;
}