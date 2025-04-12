package lecture07;

import java.util.EmptyStackException;

public class ListStack {
    class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int d, ListNode n) {
            data = d;
            next = n;
        }
    }

    // Top of stack
    private ListNode topNode;

    public ListStack() {
        topNode = null;
    }

    // Get the top element of the stack
    public int top() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        return topNode.data;
    }

    // Remove the top element of the stack
    public int pop() {
        if (topNode == null) {
            throw new EmptyStackException();
        }
        int result = topNode.data;
        topNode = topNode.next;
        return result;
    }

    // Add a new element to the top of the stack
    public void push(int newItem) {
        topNode = new ListNode(newItem, topNode);
    }

    public static void main(String[] args) {
        ListStack stack = new ListStack();

        // Pushing elements onto the stack
        for (int i = 1; i <= 15; i++) {
            stack.push(i);
        }

        // Displaying the stack
        System.out.println("Top element: " + stack.top());
        System.out.println("Stack contents after pop: " + stack.pop());
    }
}
