public class ArrayBag<T> implements Bag<T>{



   private T[] items;

   private int size;


    public ArrayBag(int capacity){
        if(capacity <= 0 ){
            throw  new IllegalArgumentException("ENTER MORE THEN ZERO");
        }
        this.size = 0;
        this.items = (T[]) new Object[capacity];
    }


    @Override
    public void add(T item) {
        if(size >= items.length){
            throw new IllegalArgumentException("cant add , is full");
        }
        items[size++] = item;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T item) {
        for(int i = 0 ; i < size ; i++){
          if(items[i].equals(item)){
              return true;
          }
      }
    return false;
    }
}