public class LinkedStack<T> implements Stack<T> {
    private Node<T> top; // Reference to the top of the stack
    private int size;    // Number of elements in the stack

    // Constructor
    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    // Adds an item to the top of the stack
    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Removes and returns the item from the top of the stack
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Returns the item at the top of the stack without removing it
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return top.data;
    }

    // Returns true if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Returns the total number of items in the stack
    @Override
    public int size() {
        return size;
    }
}