package tutorial11;

import java.util.HashMap;

public class Vertex {
    public int id; // Vertex ID
    public HashMap<Vertex, Integer> adjacencyList; // Adjacency list (neighbors and weights)

    public Vertex(int id) {
        this.id = id; // Initialize vertex ID
        this.adjacencyList = new HashMap<>(); // Initialize adjacency list
    }

    /*
     * This defines how two Vertex objects are considered equal:
     * 
     * If they refer to the same memory location (this == obj), return true.
     * 
     * If the other object is not a Vertex, return false.
     * 
     * Otherwise, compare their IDs. If the IDs match, the vertices are considered
     * equal.
     * 
     * This is important because HashMaps use equals() to compare keys when
     * resolving collisions.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; // Check if the same object
        if (!(obj instanceof Vertex))
            return false; // Check if it's a Vertex
        return this.id == ((Vertex) obj).id; // Compare IDs
    }

    /*
     * Ensures equal vertices have the same hash when used in
     * hash-based collections
     */

    @Override
    public int hashCode() {
        return Integer.hashCode(id); // Generate hash code based on ID
    }

    @Override
    public String toString() {
        return "Vertex " + id; // String representation of the vertex
    }
}
