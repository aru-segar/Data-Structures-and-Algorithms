package tutorial09;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixGraph extends Graph {

    boolean[][] adjacencyMatrix;

    public MatrixGraph(int s) {
        super(s);
        adjacencyMatrix = new boolean[size][size];
    }

    @Override
    public void addEdge(int from, int to) {
        if (from >= 0 && from < size && to >= 0 && to < size) {
            adjacencyMatrix[from][to] = true; // Add an edge from 'from' to 'to'
            // If the graph is undirected, add the reverse edge as well
            // adjacencyMatrix[to][from] = true; // Uncomment this line for undirected graph
        } else {
            throw new IndexOutOfBoundsException("Vertex index out of bounds");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder for efficient string concatenation
        sb.append("Graph adjacency matrix:\n"); // Header

        for (int i = 0; i < size; i++) { // Iterate through each vertex
            for (int j = 0; j < size; j++) { // Iterate through its neighbors
                sb.append(adjacencyMatrix[i][j] ? "1 " : "0 "); // Append each neighbor
            }
            sb.append("\n"); // New line after each row
        }

        return sb.toString(); // Return the string representation of the graph
    }

    @Override
    public void DFS() {
        System.out.println("DFS Traversal (MatrixGraph):");
        boolean[] visited = new boolean[size]; // Array to track visited vertices
        DFS(0, visited); // Start DFS from vertex 0
        System.out.println();
    }

    // Recursive DFS helper method
    private void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current vertex visited
        System.out.print(vertex + " "); // Print the current vertex

        // Visit all neighbors of the current vertex
        for (int neighbor = 0; neighbor < size; neighbor++) {
            if (adjacencyMatrix[vertex][neighbor] && !visited[neighbor]) { // Check if there's an edge and if not
                                                                           // visited
                DFS(neighbor, visited); // Recursively visit the neighbor
            }
        }
    }

    @Override
    public void BFS() {
        System.out.println("BFS Traversal (MatrixGraph):");
        boolean[] visited = new boolean[size]; // Array to track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        visited[0] = true; // Mark the start vertex as visited
        queue.add(0); // Enqueue the start vertex

        while (!queue.isEmpty()) { // While there are vertices to process
            int currentVertex = queue.poll(); // Dequeue a vertex
            System.out.print(currentVertex + " "); // Print the current vertex

            // Visit all unvisited neighbors of the current vertex
            for (int neighbor = 0; neighbor < size; neighbor++) {
                if (adjacencyMatrix[currentVertex][neighbor] && !visited[neighbor]) { // Check if there's an edge and if
                                                                                      // not visited
                    visited[neighbor] = true; // Mark the neighbor as visited
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }
    }
}
