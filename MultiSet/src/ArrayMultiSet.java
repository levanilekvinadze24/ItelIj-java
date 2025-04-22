public class ArrayMultiSet<T> implements MultiSet<T>{

    private T[] elements;
    private int size;
    private int distinctsize;
    private int[] counts;
    private int capacity;

    public ArrayMultiSet(int capacity){
        if(capacity<= 0){
            throw new IllegalArgumentException("ENTER MORE THEN ZERO!");
        }

        this.size = 0 ;
        this.distinctsize = 0;
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.counts = new int[capacity];


    }

    @Override
    public void add(T item) {
        if(size >= capacity){
            throw  new IllegalArgumentException("IS FULL");
        }

        for(int i = 0 ; i < distinctsize ; i++){
            if(elements[i].equals(item)){
                counts[i]++;
                size++;
                return;
            }
        }

        //new element
      elements[distinctsize] = item;
        counts[distinctsize] = 1;
        size++;
        distinctsize++;
    }

    @Override
    public int count(T item) {
        for(int i = 0 ; i < distinctsize ; i++){
            if(elements[i].equals(item)){
                return counts[i];
            }
        }
        return 0;
    }

    @Override
    public boolean contains(T item) {
        for(int i = 0 ; i < distinctsize ; i++){
            if(elements[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int distincsize() {
        return distinctsize;
    }

    @Override
    public void prindItems() {
           for(int i = 0 ; i < distinctsize ; i++){
               System.out.println(elements[i] + " ( " +  counts[i] + " ) ");
           }
    }
}