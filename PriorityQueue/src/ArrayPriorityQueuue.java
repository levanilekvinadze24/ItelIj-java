public class ArrayPriorityQueuue<T> implements PriorityQueue<T> {

    private Object[] items;        // Array to store items
    private int[] priorities;      // Array to store priorities
    private int head;              // Index of the element with the highest priority
    private int tail;              // Index where the next item will be inserted
    private int size;              // Current number of elements in the queue
    private int capacity;          // Maximum capacity of the queue

    public ArrayPriorityQueuue(int capacity) {
        this.items = new Object[capacity];
        this.priorities = new int[capacity];
        this.head = -1;           // Initially, no element in the queue
        this.tail = 0;            // First insertion starts at index 0
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T item, int priority) {
        items[tail] = item;
        priorities[tail] = priority;

        // If the queue was empty, set head to the first inserted element
        if (head == -1) {
            head = tail;
        } else {
            // Update head if the new item has a higher priority
            if (priority > priorities[head]) {
                head = tail;
            }
        }

        // Increment tail; reset to 0 if it reaches the end of the array
        tail++;
        if (tail == capacity) {
            tail = 0;
        }

        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        // The highest priority element is at the head index
        T item = (T) items[head];

        // Shift all elements after the head to fill the gap
        int index = head;
        while (index != tail - 1 && index != capacity - 1) {
            items[index] = items[index + 1];
            priorities[index] = priorities[index + 1];
            index++;
        }

        if (index == tail - 1) {
            // Adjust tail to the end
            tail--;
        } else if (index == capacity - 1) {
            tail--;
        }

        size--;

        // Recalculate the head to find the highest priority element
        if (size == 0) {
            head = -1;
        } else {
            head = 0;
            for (int i = 0; i < size; i++) {
                if (priorities[i] > priorities[head]) {
                    head = i;
                }
            }
        }

        return item;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
}
