package Stack_Queues.basic;

/**
 * A simple implementation of a Queue using arrays.
 * This queue supports basic operations: enqueue, dequeue,
 * getFront, getRear, isEmpty, and isFull.
 */
class ArrayQueue {
    private int[] arr; // Array to store queue elements
    int capacity; // Maximum capacity of the queue
    int size; // Current number of elements in the queue

    /**
     * Constructor to initialize the queue with a given capacity.
     * 
     * @param _capacity Maximum number of elements the queue can hold
     */
    ArrayQueue(int _capacity) {
        this.capacity = _capacity;
        this.arr = new int[this.capacity];
        this.size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * 
     * @param value Element to be added
     */
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow...!");
            return;
        }
        arr[size++] = value; // Insert at the end and increase size
    }

    /**
     * Removes an element from the front of the queue.
     * Shifts all remaining elements one position to the left.
     */
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow...!");
            return;
        }

        // Shift elements to the left to maintain queue order
        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--; // Reduce size after removal
    }

    /**
     * Retrieves the front element of the queue without removing it.
     * 
     * @return Front element or -1 if the queue is empty
     */
    public int getFront() {
        if (size == 0) {
            System.out.println("Queue is empty...!");
            return -1;
        }
        return arr[0];
    }

    /**
     * Retrieves the rear element of the queue without removing it.
     * 
     * @return Rear element or -1 if the queue is empty
     */
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty...");
            return -1;
        }
        return arr[size - 1];
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * 
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Driver class to demonstrate the functionality of ArrayQueue.
 */
public class ImplementationOfSimpleQueueUsingArray {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3); // Create a queue of capacity 3

        // Enqueue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display front element
        System.out.println("Front: " + queue.getFront());

        // Dequeue operation
        queue.dequeue();

        // Display updated front and rear elements
        System.out.println("Front: " + queue.getFront());
        System.out.println("Rear: " + queue.getRear());

        // Enqueue another element after dequeue
        queue.enqueue(40);
    }
}