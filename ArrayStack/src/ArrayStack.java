public class ArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int size;
    private int capacity;

    // Constructor
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero!");
        }
        this.size = 0;
        this.stack = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    // Resize the stack when it exceeds capacity
    private void resize() {
       capacity = capacity * 2 ;
       T[] newstack = (T[]) new Object[capacity];

       for(int i = 0 ; i < size ; i++){
           newstack[i] = stack[i];
       }
       stack = newstack;
    }

    @Override
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null!");
        }
        if (size >= capacity) {
            resize(); // Double the capacity if needed
        }
        stack[size++] = item; // Add the item and increment size
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        T item = stack[--size]; // Decrement size and retrieve the top item
        stack[size] = null; // Avoid memory leaks by clearing the reference
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return stack[size - 1]; // Return the top item without removing it
    }

    @Override
    public int size() {
        return size; // Return the current size of the stack
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // Stack is empty if size is zero
    }
}