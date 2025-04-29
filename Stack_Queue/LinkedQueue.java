
public class LinkedQueue {
    private ListImpl head;
    private ListImpl tail;

    public LinkedQueue() {
        head = tail = null;
    }

    public int size() {
        if (head == null ) return 0;
        return head.length();
    }

    public void enqueue(int e) {//amatebs push
        if (head == null) head = tail = new ListImpl(e);
        else{
            tail.insert(e);
            tail = tail.getNext();
        }
    }

    public int dequeue() {//aklebs  pop
        if (size() == 0) return -1;

        int result = head.getInfo();
        if (head == tail) tail = null;
        head = head.getNext();
        return result;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}