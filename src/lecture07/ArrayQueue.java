package lecture07;

public class ArrayQueue {
    public static int capacity = 10;
    private int[] items;
    int front = 0, back = 0;

    public ArrayQueue() {
        items = new int[capacity];
    }

    public void queue(int d) {
        if (back == capacity) {
            System.out.println("Queue is full. Cannot queue " + d);
            return;
        }
        items[back] = d;
        back++;
    }

    public int dequeue() {
        if (front == back) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // or throw an exception
        }
        int dequeuedItem = items[front];
        front++;
        return dequeuedItem;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        // Queueing elements
        for (int i = 1; i <= 15; i++) {
            queue.queue(i);
        }

        // Dequeuing elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Displaying the queue
        System.out.print("Queue contents: [ ");
        for (int i = queue.front; i < queue.back; i++) {
            System.out.print(queue.items[i] + " ");
        }
        System.out.println("]");
    }
}
