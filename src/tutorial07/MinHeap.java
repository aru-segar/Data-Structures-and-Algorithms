package tutorial07;

import java.util.EmptyStackException;

public class MinHeap {
    private int[] items;

    private static final int INITIAL_CAPACITY = 1000;

    private int size;

    public MinHeap() {
        items = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public static int parentIndex(int index) {
        return ((index - 1) / 2);
    }

    public static int leftChildIndex(int index) {
        return ((2 * index) + 1);
    }

    public static int rightChildIndex(int index) {
        return ((2 * index) + 2);
    }

    public void insert(int newItem) {
        if (size == items.length) {
            // need to grow
            int[] temp = new int[2 * size];

            System.arraycopy(items, 0, temp, 0, size);

            items = temp;
        }

        // Determine position for insertion:
        // begin at index==size, then sift up, pushing bigger elements down

        int index = size;

        while (index > 0) {
            int parent = parentIndex(index);

            if (items[parent] > newItem) {
                items[index] = items[parent];
                index = parent;
            } else {
                break;
            }
        }
        items[index] = newItem;
        size++;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int getMinimum() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return items[0];
        }
    }

    public int extractMinimum() {
        if (empty()) {
            throw new EmptyStackException();
        }

        int result = items[0];

        // determine position to re-insert items[size-1]:
        // begin at index==0, then sift down, pulling elements up

        int index = 0, child = 1;

        size--;

        while (child < size) {
            // at this point, child is the left child of index;
            // pick the right child instead if it exists and has a smaller value

            if ((child + 1 < size) && (items[child] > items[child + 1])) {
                child++;
            }

            if (items[child] < items[size]) {
                items[index] = items[child];
                index = child;
                child = leftChildIndex(index);
            } else {
                break;
            }
        }

        items[index] = items[size];

        return result;
    }

    public void printItems() {
        System.out.print("Array representation: [ ");

        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }

        System.out.println("]");
    }

    public void heapify(int index) {
        int smallest = index;
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);

        if (left < size && items[left] < items[smallest]) {
            smallest = left;
        }

        if (right < size && items[right] < items[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            // Swap
            int temp = items[index];
            items[index] = items[smallest];
            items[smallest] = temp;

            heapify(smallest);
        }
    }

    public void buildHeap(int[] array) {
        size = array.length;
        items = new int[size];
        System.arraycopy(array, 0, items, 0, size);

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MinHeap h = new MinHeap();

        int[] a = { 6, 3, 7, 4, 2, 8, 1, 5, 0 };

        System.out.println();
        System.out.println("Building Heap using buildHeap():");
        h.buildHeap(a);
        h.printItems();
        System.out.println("Minimum element: " + h.getMinimum());

        System.out.println();
        System.out.println("Extract Values from Heap in ascending order: ");

        while (!h.empty()) {
            int m = h.extractMinimum();
            System.out.print("Extracted value " + m);

            if (h.empty()) {
                System.out.println(", heap is now empty");
            } else {
                System.out.println(", minimum element is now " + h.getMinimum());
            }
        }
    }
}