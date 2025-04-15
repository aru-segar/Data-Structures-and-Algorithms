package tutorial11;

import java.util.ArrayList; 

public class MinHeap {
    ArrayList<WrappedVertex> items; // ArrayList to store wrapped vertices

    public MinHeap() {
        items = new ArrayList<>(); // Initialize the ArrayList
    }

    public void insert(Vertex vertex, int distance) {
        WrappedVertex newItem = new WrappedVertex(vertex, distance); // Wrap the vertex with its distance
        int index = items.size(); // Get the current size of the heap
        items.add(newItem); // Add the new item to the end of the heap

        // Sift up to maintain the heap property
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Calculate the parent index
            WrappedVertex parent = items.get(parentIndex); // Get the parent item

            if (parent.compareTo(newItem) > 0) { // If the parent is greater than the new item
                items.set(index, parent); // Move the parent down
                index = parentIndex; // Move up to the parent's index
            } else {
                break; // The heap property is satisfied
            }
        }
        items.set(index, newItem); // Place the new item in its correct position
    }
}
