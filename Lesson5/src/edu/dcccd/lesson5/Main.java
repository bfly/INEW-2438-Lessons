package edu.dcccd.lesson5;

import edu.dcccd.dijkstra.DijkstraAlgorithm;
import edu.dcccd.graph.Edge;
import edu.dcccd.graph.Graph;
import edu.dcccd.graph.Vertex;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.lines;

public class Main {

    private List<InputRecord> inputRec;
    private List<RequestedRecord> requests;
    private Set<Vertex> nodes;
    private List<Edge> edgesC;
    private List<Edge> edgesT;
    private List<Edge> savedEdgesC;
    private List<Edge> savedEdgesT;
    private int totalTime;
    private int totalCost;

    private Main() {
        inputRec = new ArrayList<>();
        requests = new ArrayList<>();
        nodes = new TreeSet<>();
        edgesC = new ArrayList<>();
        edgesT = new ArrayList<>();
        savedEdgesC = new ArrayList<>();
        savedEdgesT = new ArrayList<>();
    }

    private void go() {
        String source, target;
        int time, cost;

        // read the flight data
        try {
            lines(Paths.get("FlightData"))              // file name
                .skip(1)                                    // skip 1st record
                .map(s -> s.split("\\|"))             // pipe delimiter
                .map(InputRecord ::new)
                .forEach(r-> {
                    inputRec.add(r);              // add input record
                    nodes.add(new Vertex(r.getSource()));    // add source vertex
                    nodes.add(new Vertex(r.getTarget()));    // add target vertex
                });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create an edge and add it to the list
        for ( InputRecord ir: inputRec ) {
            source = ir.getSource();
            target = ir.getTarget();
            cost = ir.getCost();
            time = ir.getTime();

            edgesC.add(new Edge(source + "->" + target, new Vertex(source), new Vertex(target), cost));
            edgesT.add(new Edge(source + "->" + target, new Vertex(source), new Vertex(target), time));
        }

        // save edges
        savedEdgesC.addAll(edgesC);
        savedEdgesT.addAll(edgesT);

        // read requested flights
        try {
            lines(Paths.get("RequestedFlights"))        // file name
                .skip(1)                                    // skip 1st record
                .map(s -> s.split("\\|"))             // pipe delimiter
                .map(RequestedRecord ::new)
                .forEach(requests :: add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DijkstraAlgorithm dijkstra;
        Graph graph;
        Vertex sourceNode, targetNode;
        char costOrTime;
        int j = 0;

        for (RequestedRecord req: requests) {
            source = req.getFrom();
            target = req.getTo();
            costOrTime = req.getStipulation();
            String type = (costOrTime == 'C') ? "Cost" : "Time";
            System.out.println("Flight " + (++j) + ": " + source + ", " + target + " (" + type + ")");

            edgesC.clear();
            edgesT.clear();
            edgesC.addAll(savedEdgesC);            // restore edges
            edgesT.addAll(savedEdgesT);

            //  find three paths between the departure and destination cities
            sourceNode = new Vertex(source);
            targetNode = new Vertex(target);
            if (!nodes.contains(sourceNode)) { System.out.println("No flights from " + source + "\n"); continue; }
            if (!nodes.contains(targetNode)) { System.out.println("No flights to " + target + "\n"); continue; }
            for ( int n = 0; n < 3; n++ ) {
                totalCost = totalTime = 0;
                // load the cost or time into the graph
                if ( costOrTime == 'C' )
                     graph = new Graph(new ArrayList<>(nodes), edgesC);
                else graph = new Graph(new ArrayList<>(nodes), edgesT);
                dijkstra = new DijkstraAlgorithm(graph);
                dijkstra.execute(sourceNode);                        // locate shortest path
                List<Vertex> path = dijkstra.getPath(targetNode);    // retrieve that path
                if ( path != null && !path.isEmpty() ) {
                    System.out.print("Path " + (n + 1) + ": ");           // print path
                    for ( int i = 0; i < path.size(); i++ ) {
                        System.out.print(path.get(i).getName());
                        if ( path.get(i).getName().equals(target) ) {
                            System.out.println(". Time: " + totalTime + " Cost: " + totalCost);
                        } else {
                            accumulateTimeAndCost(path.get(i).getName(), path.get(i + 1).getName(), edgesT, edgesC);
                            System.out.print(" -> ");
                        }
                    }
                } else if ( n == 0 ) { System.out.println("No connection available."); break; }
            }
            System.out.println();
        }
    }

    // this routine retrieves and accumulates the time and cost of a leg of the path and removed the edge from the network
    private void accumulateTimeAndCost(String source, String target, List<Edge> edgesT, List<Edge> edgesC) {
        String st = source + "->" + target;
        totalTime += sumAndRemoveEdge(edgesT, st);
        totalCost += sumAndRemoveEdge(edgesC, st);
    }

    private int sumAndRemoveEdge(List<Edge> edges, String st) {
        Edge edge;
        int sum = 0;
        for ( int i = 0; i < edges.size(); i++ ) {
            edge = edges.get(i);
            if(edge.getId().equals(st)) {
                sum += edge.getWeight();
                edges.remove(i);
                break;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        new Main().go();
    }        // main entry point
}