//Q9: Write a Program to implement DFS(Depth-First Search) and BFS(Breadth-First Search) for a graph
package com.shri.java;

import java.util.*;

class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    // Depth-First Search (DFS)
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        System.out.println("Depth-First Search starting from vertex " + startVertex + ":");
        DFSUtil(startVertex, visited);
        System.out.println();
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // Breadth-First Search (BFS)
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("Breadth-First Search starting from vertex " + startVertex + ":");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

public class Graph1 {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform DFS starting from vertex 0
        graph.DFS(0);

        // Perform BFS starting from vertex 0
        graph.BFS(0);
    }
}
