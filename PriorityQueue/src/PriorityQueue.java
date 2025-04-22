public interface PriorityQueue<T> {

    void enqueue(T item , int priority);


    T dequeue();
    int size();
    boolean isEmpty();
    boolean contains(T item);

}
