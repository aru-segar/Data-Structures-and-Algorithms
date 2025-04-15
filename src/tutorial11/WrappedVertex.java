package tutorial11;

public class WrappedVertex implements Comparable<WrappedVertex> {
    public Vertex vertex; // Wrapped vertex object
    public int distance; // Distance from the source vertex

    public WrappedVertex(Vertex vertex, int distance) {
        this.vertex = vertex; // Initialize wrapped vertex
        this.distance = distance; // Initialize distance
    }

    @Override
    public int compareTo(WrappedVertex other) { 
        return Integer.compare(this.distance, other.distance); // Compare distances for priority queue
    }
}
