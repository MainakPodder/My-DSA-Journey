package Stack_Queues.basic;

/**
 * Implementation of a Circular Queue using an array.
 * This queue supports enqueue, dequeue, getFront, getRear,
 * and checks for empty/full states.
 */
class ArrayCircularQueue {
    private int[] arr;       // Array to store queue elements
    private int capacity;    // Maximum capacity of the queue
    private int front;       // Index of the front element
    private int size;        // Current number of elements in the queue

    /**
     * Constructor to initialize the queue with a given capacity.
     * @param _capacity Maximum number of elements the queue can hold
     */
    ArrayCircularQueue(int _capacity) {
        this.capacity = _capacity;
        this.arr = new int[this.capacity];
        this.front = 0;
        this.size = 0;
    }

    /**
     * Adds an element to the rear of the queue.
     * Uses circular indexing to wrap around when needed.
     * @param value Element to be added
     */
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow...!");
            return;
        }

        int rear = (front + size) % capacity; // Calculate rear index
        arr[rear] = value;
        size++;
    }

    /**
     * Removes and returns the front element of the queue.
     * Updates front index using circular wrap-around.
     * @return Removed element or -1 if queue is empty
     */
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow...!");
            return -1;
        }

        int value = arr[front];              // Get front element
        front = (front + 1) % capacity;      // Move front forward
        size--;
        return value;
    }

    /**
     * Checks if the queue is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Retrieves the front element without removing it.
     * @return Front element or -1 if queue is empty
     */
    public int getFront() {
        if (size == 0) {
            System.out.println("Queue is empty...!");
            return -1;
        }
        return arr[front];
    }

    /**
     * Retrieves the rear element without removing it.
     * Uses circular indexing to find the last element.
     * @return Rear element or -1 if queue is empty
     */
    public int getRear() {
        if (size == 0) {
            System.out.println("Queue is empty...!");
            return -1;
        }

        int rear = (front + size - 1) % capacity; // Calculate rear index
        return arr[rear];
    }
}

/**
 * Driver class to demonstrate Circular Queue operations.
 */
public class ImplementationOfCircularQueueUsingArray {
    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        // Enqueue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display front and rear values
        System.out.printf("Front: %d & Rear: %d%n", queue.getFront(), queue.getRear());

        // Dequeue operation (removes 10)
        queue.dequeue();
        System.out.printf("Front: %d, Rear: %d%n", queue.getFront(), queue.getRear());

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Wrap-around happens here
        System.out.printf("Front: %d, Rear: %d%n", queue.getFront(), queue.getRear());

        // Attempt to enqueue when full
        queue.enqueue(70); // Should print "Queue Overflow...!"
        System.out.printf("Front: %d, Rear: %d%n", queue.getFront(), queue.getRear());
    }
}