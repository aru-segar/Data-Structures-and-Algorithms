package tutorial11;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ListGraph {
    int size; // number of vertices
    ArrayList<ArrayList<Integer>> adjacency; // adjacency list

    public ListGraph(int s) {
        size = s;
        adjacency = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            adjacency.add(new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjacency.get(from).add(to);
    }

    public void removeEdge(int from, int to) {
        adjacency.get(from).remove(to);
    }

    public void addEdgesFromFile(Scanner s) {
        while (s.hasNextInt())
            addEdge(s.nextInt(), s.nextInt());
    }

    private void printPath(int i, HashMap<Integer, Integer> predecessor) {
        System.out.print(i);
        if (predecessor.containsKey(i))
            while (i > 0) {
                i = predecessor.get(i);
                System.out.print(" <- " + i);
            }
        else
            System.out.print(" is not reachable");
        System.out.println("");
    }

    public void BFS() {
        LinkedList<Integer> open = new LinkedList<>(); // queue of vertices to be explored
        HashMap<Integer, Integer> closed = new HashMap<>(); // map of vertices already explored
        HashMap<Integer, Integer> predecessor = new HashMap<>(); // map of predecessors

        open.addLast(0); // start with the first vertex
        closed.put(0, 0); // mark it as explored
        predecessor.put(0, -1); // no predecessor for the start vertex

        while (!open.isEmpty()) { // while there are vertices to explore
            int i = open.removeFirst(); // get the first vertex in the queue

            for (int j : adjacency.get(i)) // for each neighbor of the current vertex
                if (!closed.containsKey(j)) { // if it hasn't been explored yet
                    open.addLast(j); // add it to the queue
                    closed.put(j, 1 + closed.get(i)); // mark it as explored
                    predecessor.put(j, i); // set its predecessor
                }
        }
        // Print the number of edges in the shortest path to each vertex
        System.out.println("Shortest paths:");
        for (int i = 0; i < size; i++)
            printPath(i, predecessor);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("src\\tutorial09\\example1.txt"));
        } catch (Exception e) {
            System.out.println("Failed to open input file");
        }

        ListGraph g = new ListGraph(s.nextInt());
        g.addEdgesFromFile(s);
        g.BFS();
    }
}
