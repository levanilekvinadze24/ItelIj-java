import java.util.Iterator;
import java.util.NoSuchElementException;

interface PriorityQueue<T> {
    void enqueue(T item, int priority);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}

public class LinkedPriorityQueue<T> implements PriorityQueue<T> {
    private class Node {
        T item;
        int priority;
        Node next;

        Node(T item, int priority) {
            this.item = item;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedPriorityQueue() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T item, int priority) {
        Node newNode = new Node(item, priority);

        if (head == null || priority > head.priority) {
            // Insert at the head if the queue is empty or the priority is higher
            newNode.next = head;
            head = newNode;
        } else {
            // Traverse the list to find the correct position
            Node current = head;
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            // Insert the new node in the correct position
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T item = head.item;
        head = head.next; // Remove the head
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        return head.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        PriorityQueue<String> pq = new LinkedPriorityQueue<>();

        pq.enqueue("apple", 2);
        pq.enqueue("orange", 5);
        pq.enqueue("banana", 1);
        pq.enqueue("grape", 3);

        System.out.println("Size: " + pq.size()); // Output: 4
        System.out.println("Peek: " + pq.peek()); // Output: orange

        System.out.println("Dequeue: " + pq.dequeue()); // Output: orange
        System.out.println("Dequeue: " + pq.dequeue()); // Output: grape
        System.out.println("Dequeue: " + pq.dequeue()); // Output: apple

        pq.enqueue("pear", 4);
        System.out.println("Peek: " + pq.peek()); // Output: pear

        // Iterate through the priority queue
        System.out.println("Iterating through the priority queue:");
        Iterator<String> iterator = ((LinkedPriorityQueue<String>) pq).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
