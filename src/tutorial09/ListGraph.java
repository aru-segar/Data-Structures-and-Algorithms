package tutorial09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListGraph extends Graph {

    ArrayList<ArrayList<Integer>> adjacency;

    public ListGraph(int s) {
        super(s);
        adjacency = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            adjacency.add(new ArrayList<>());
    }

    @Override
    public void addEdge(int from, int to) {
        // Add an edge from 'from' to 'to' in the adjacency list
        if (from >= 0 && from < size && to >= 0 && to < size) {
            adjacency.get(from).add(to);
            // If the graph is undirected, add the reverse edge as well
            // adjacency.get(to).add(from); // Uncomment this line for undirected graph
        } else {
            throw new IndexOutOfBoundsException("Vertex index out of bounds");
        }
    }

    @Override
    public String toString() {
        // Build a string representation of the graph
        StringBuilder sb = new StringBuilder(); // StringBuilder for efficient string concatenation
        sb.append("Graph adjacency list:\n"); // Header
        for (int i = 0; i < size; i++) { // Iterate through each vertex
            sb.append(i).append(": "); // Vertex number
            for (Integer neighbor : adjacency.get(i)) { // Iterate through its neighbors
                sb.append(neighbor).append(" "); // Append each neighbor
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void DFS() {
        System.out.println("DFS Traversal (ListGraph):");
        boolean[] visited = new boolean[size]; // Array to track visited vertices
        DFS(0, visited); // Start DFS from vertex 0
        System.out.println();
    }

    // Recursive DFS helper method
    private void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current vertex visited
        System.out.print(vertex + " "); // Print the current vertex

        // Visit all neighbors of the current vertex
        for (int neighbor : adjacency.get(vertex)) {
            if (!visited[neighbor]) { // If the neighbor hasn't been visited
                DFS(neighbor, visited); // Recursively visit it
            }
        }
    }

    @Override
    public void BFS() {
        System.out.println("BFS Traversal (ListGraph):");
        boolean[] visited = new boolean[size]; // Array to track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        visited[0] = true; // Mark the start vertex as visited
        queue.add(0); // Enqueue the start vertex

        while (!queue.isEmpty()) { // While there are vertices to process
            int currentVertex = queue.poll(); // Dequeue a vertex
            System.out.print(currentVertex + " "); // Print the current vertex

            // Visit all unvisited neighbors of the current vertex
            for (int neighbor : adjacency.get(currentVertex)) {
                if (!visited[neighbor]) { // If the neighbor hasn't been visited
                    visited[neighbor] = true; // Mark it as visited
                    queue.add(neighbor); // Enqueue it for future exploration
                }
            }
        }
    }
}
