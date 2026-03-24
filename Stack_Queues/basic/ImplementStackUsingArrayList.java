package Stack_Queues.basic;

import java.util.ArrayList;

/**
 * A simple stack implementation using Java's ArrayList.
 * Provides standard stack operations: push, pop, peek, size, and isEmpty.
 */
class ArrayListStack {
    // Internal storage for stack elements
    ArrayList<Integer> arr = new ArrayList<>();

    /**
     * Pushes an element onto the stack.
     * 
     * @param value Element to be added
     */
    public void push(int value) {
        arr.add(value);
    }

    /**
     * Pops (removes and returns) the top element of the stack.
     * Handles underflow if stack is empty.
     * 
     * @return The popped element, or -1 if stack is empty
     */
    public int pop() {
        if (arr.size() == 0) {
            System.out.println("Stack Underflow...!");
            return -1;
        }
        int index = arr.size() - 1;
        int value = arr.get(index); // Store top element
        arr.remove(index); // Remove it from stack
        return value; // Return popped element
    }

    /**
     * Returns the top element without removing it.
     * 
     * @return Top element, or -1 if stack is empty
     */
    public int peek() {
        if (arr.size() == 0) {
            System.out.println("Stack is Empty...!");
            return -1;
        }
        int index = arr.size() - 1;
        return arr.get(index);
    }

    /**
     * Returns the current number of elements in the stack.
     * 
     * @return Size of stack
     */
    public int size() {
        return arr.size();
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return arr.isEmpty();
    }
}

/**
 * Driver class to demonstrate stack operations using ArrayList.
 */
public class ImplementStackUsingArrayList {
    public static void main(String[] args) {
        ArrayListStack stack = new ArrayListStack(); // Create stack instance

        // Push elements into the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Demonstrate stack operations
        System.out.println("Popped: " + stack.pop()); // Removes top element
        System.out.println("Top element: " + stack.peek()); // Shows current top
        System.out.println("Is stack empty: " + (stack.isEmpty() ? "Yes" : "No"));
        System.out.println("Current size: " + stack.size()); // Shows stack size
    }
}