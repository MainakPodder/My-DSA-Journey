package Stack_Queues.basic;

/**
 * A simple implementation of a stack using arrays.
 * Provides basic stack operations: push, pop, peek, isEmpty, and isFull.
 */
class ArrayStack {
    private int[] arr; // Array to store stack elements
    private int capacity; // Maximum capacity of the stack
    private int top; // Index of the top element in the stack

    /**
     * Constructor to initialize the stack with a given capacity.
     * 
     * @param _capacity Maximum number of elements the stack can hold
     */
    ArrayStack(int _capacity) {
        this.capacity = _capacity;
        this.arr = new int[_capacity];
        this.top = -1; // Stack is initially empty
    }

    /**
     * Pushes an element onto the stack.
     * 
     * @param value Element to be pushed
     */
    public void push(int value) {
        // Check for stack overflow
        if (top == capacity - 1) {
            System.out.println("Stack Overflow...!");
            return;
        }
        arr[++top] = value; // Increment top and insert value
    }

    /**
     * Pops the top element from the stack.
     * 
     * @return The popped element, or -1 if stack is empty
     */
    public int pop() {
        // Check for stack underflow
        if (top == -1) {
            System.out.println("Stack Underflow...!");
            return -1;
        }
        return arr[top--]; // Return top element and decrement top
    }

    /**
     * Returns the top element of the stack without removing it.
     * 
     * @return Top element of the stack
     */
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty...!");
            return -1;
        }
        return arr[top];
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     * 
     * @return true if stack is full, false otherwise
     */
    public boolean isFull() {
        return top == capacity - 1;
    }
}

/**
 * Driver class to demonstrate stack operations.
 */
public class ImplementStackUsingArrays {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5); // Create a stack of capacity 5

        // Push elements into the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Demonstrate stack operations
        System.out.println("Popped: " + stack.pop()); // Removes top element
        System.out.println("Top element: " + stack.peek()); // Shows current top
        System.out.println("Is stack empty: " + (stack.isEmpty() ? "Yes" : "No"));
        System.out.println("Is stack full: " + (stack.isFull() ? "Yes" : "No"));
    }
}