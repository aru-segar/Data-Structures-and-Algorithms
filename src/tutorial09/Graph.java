package tutorial09;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
    int size;

    public Graph(int s) {
        size = s;
    }

    public void addEdge(int from, int to) {
    }

    public void removeEdge(int from, int to) {
    }

    public void addEdgesFromFile(Scanner s) {
        // As long as there are numbers left, read two and use them to add an edge
        while (s.hasNextInt())
            addEdge(s.nextInt(), s.nextInt());
    }

    public String toString() {
        // TO DO: Override in subclasses
        return "";
    }

    // Creates a path from a predecessor map
    public LinkedList getPath(HashMap<Integer, Integer> predecessor, int vertex) {
        LinkedList<Integer> vertices = new LinkedList<>(); // List of vertices in the path
        Stack<Integer> reverse = new Stack<>(); // Stack to reverse the order of the vertices
        // First push the vertices onto the stack; they will be in reverse order
        reverse.push(vertex);
        while (vertex != 0) { // 0 is the start vertex
            vertex = predecessor.get(vertex); // Get the predecessor of the current vertex
            reverse.push(vertex); // Push it onto the stack
        }
        // Then pop them; this will get them in the right order
        while (!reverse.empty())
            vertices.add(reverse.pop());
        return vertices;
    }

    public void DFS() {
        // TO DO: Override in subclasses
    }

    public void BFS() {
        // TO DO: Override in subclasses
    }

    public static void printPath(List<Integer> path) {
        if (path == null)
            System.out.println("No path found");
        else {
            for (int i : path)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Control parameters:
        // Input file name
        String inputFile = "src\\tutorial09\\example1.txt";
        // Type of graph (true -> adjacency list, false -> adjacency matrix)
        boolean useList = false;

        // 1. Create a Scanner to read a graph description from a file
        Scanner s = null;
        try {
            s = new Scanner(new File(inputFile));
        } catch (Exception e) {
            System.out.println("Could not open input file");
            System.exit(0);
        }
        // 2. Create a graph of the size given in the file
        // Either a ListGraph or a MatrixGraph, determined by useList
        Graph g = useList ? new ListGraph(s.nextInt()) : new MatrixGraph(s.nextInt());

        // 3. Add all the edges defined in the file
        g.addEdgesFromFile(s);

        // 4. Print the completed graph
        System.out.println(g.toString());

        // 5. Perform DFS on the graph to find a suitable path
        g.DFS();

        // 6. Perform BFS on the graph to find a suitable path
        g.BFS();
    }
}
