public interface Bag<T> {


    void add(T item);
    int size();
    boolean contains(T item);
}