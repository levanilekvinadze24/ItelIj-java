public interface MultiSet<T>  {

    void add(T item); //add element , if it exsists encrement by 1 .


    int count(T item); // count of specified element
    boolean contains(T item);

    int size();
    int distincsize();
    void prindItems(); // item ( count ) ;
}