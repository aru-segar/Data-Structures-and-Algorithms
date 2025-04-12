package tutorial07;

public class ListQueue {
    public class Node {
        public int data;
        public Node next;

        public Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

    private Node first, last;

    public ListQueue() {
        first = null;
        last = null;
    }

    public void queue(int d) {
        Node newNode = new Node(d, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // or throw an exception
        }
        int dequeuedItem = first.data;
        first = first.next;
        if (first == null) {
            last = null; // Queue is now empty
        }
        return dequeuedItem;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public int length() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = first;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot access front.");
            return -1; // or throw an exception
        }
        return first.data;
    }

    public int last() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot access last.");
            return -1; // or throw an exception
        }
        return last.data;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListQueue queue = new ListQueue();

        // Queueing elements
        for (int i = 1; i <= 15; i++) {
            queue.queue(i);
        }

        // Displaying the queue
        System.out.println("Queue contents: " + queue.toString());
        System.out.println("Front element: " + queue.front());
        System.out.println("Last element: " + queue.last());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Queue length: " + queue.length());
        System.out.println("Is queue empty? " + queue.isEmpty());
        queue.clear();
        System.out.println("Queue cleared. Is queue empty? " + queue.isEmpty());
        System.out.println("Queue contents after clearing: " + queue.toString());
    }
}