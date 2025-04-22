public class ArrayQueue<T> implements Queue<T> {
    private T[] queue;    // Array to hold queue elements
    private int head;     // Index of the front element
    private int tail;     // Index where the next element will be inserted
    private int size;     // Current number of elements in the queue
    private int capacity; // Maximum capacity of the queue

    // Constructor to initialize the queue with an initial capacity
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        this.queue = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == capacity) {
            resize(); // Resize the array when it reaches full capacity
        }

        queue[tail] = item;  // Add the item at the tail
        tail++;              // Move the tail forward
        if (tail == capacity) {
            tail = 0;        // Wrap the tail back to the beginning if it reaches capacity
        }
        size++;              // Increase the size
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T item = queue[head]; // Get the front element
        queue[head] = null;   // Clear the slot for garbage collection
        head++;               // Move the head forward
        if (head == capacity) {
            head = 0;         // Wrap the head back to the beginning if it reaches capacity
        }
        size--;               // Decrease the size
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head]; // Return the front element without removing it
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // Queue is empty if size is 0
    }

    @Override
    public int size() {
        return size; // Return the number of elements in the queue
    }

    // Private method to resize the array when it reaches capacity
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        T[] newQueue = (T[]) new Object[newCapacity];

        // Copy elements to the new array in order
        int index = 0;
        for (int i = 0; i < size; i++) {
            newQueue[index++] = queue[head];
            head++;
            if (head == capacity) {
                head = 0; // Wrap the head back to the beginning if it reaches capacity
            }
        }

        queue = newQueue;       // Replace the old array with the new one
        head = 0;               // Reset head to 0
        tail = size;            // Reset tail to size
        capacity = newCapacity; // Update the capacity
    }
}
