package tutorial07;

import java.util.EmptyStackException;

public class ArrayStack {
    public static final int INITIAL_CAPACITY = 15;

    private final int[] items;

    private int size;

    public ArrayStack() {
        items = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(int newItem) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + newItem);
            return;
        }

        items[size] = newItem;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            throw new EmptyStackException();
        }

        int poppedItem = items[size - 1];
        size--;
        return poppedItem;
    }

    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        // Pushing elements onto the stack
        for (int i = 1; i <= 15; i++) {
            stack.push(i);
        }

        // Try to push an element when the stack is full
        stack.push(16);

        // Displaying the stack
        System.out.println("Stack contents: " + stack);
        System.out.println("Top element: " + stack.top());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack contents after pop: " + stack);

        // Clearing the stack
        stack.clear();
        System.out.println("Stack contents after clear: " + stack);

        // Try to pop an element when the stack is empty
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught exception: " + e);
        }
    }
}