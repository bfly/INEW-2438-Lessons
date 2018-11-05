package edu.dcccd.dijkstra;

import edu.dcccd.graph.Edge;
import edu.dcccd.graph.Graph;
import edu.dcccd.graph.Vertex;

import java.util.*;

public class DijkstraAlgorithm {

    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithm(Graph graph) {         // Constructor
         this.edges = new ArrayList<>(graph.getEdges());  // create a copy of the array so that we can operate on this array
    }

    public void execute(Vertex source) {            // Initialize algorithm for a source
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node) {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for ( Vertex target : adjacentNodes ) {
            if ( getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target) ) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private int getDistance(Vertex node, Vertex target) {
        for ( Edge edge : edges ) {
            if ( edge.getSource().equals(node) && edge.getDestination().equals(target) ) return edge.getWeight();
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for ( Edge edge : edges ) {
            if ( edge.getSource().equals(node) && !isSettled(edge.getDestination()) ) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for ( Vertex vertex : vertexes ) {
            if ( minimum == null ) minimum = vertex;
            else if ( getShortestDistance(vertex) < getShortestDistance(minimum) ) minimum = vertex;
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        return distance.get(destination) != null ? distance.get(destination) : Integer.MAX_VALUE;
    }

    /*
     * This method returns the path from the source to the selected target and NULL if no path exists
     */
    public List<Vertex> getPath(Vertex target) {
        List<Vertex> path = new LinkedList<>();
        Vertex step = target;
        if ( predecessors.get(step) == null ) return null;      // check if a path exists
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}