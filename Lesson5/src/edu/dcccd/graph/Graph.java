package edu.dcccd.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Graph {
    private List<Vertex> vertexes;
    private List<Edge> edges;
}
