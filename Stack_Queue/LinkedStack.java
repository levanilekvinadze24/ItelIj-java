
public class LinkedStack {
    private ListImpl list;

    public LinkedStack() {
        list = null;
    }

    public int size() {
        if (list == null) return 0;
        return list.length();
    }

    public void push(int e)
    {
        list = new ListImpl(e, list);
    }

    public int pop() {
        if (size() == 0) return -1;

        int result = list.getInfo();
        list = list.getNext();
        return result;
    }

    @Override
    public String toString() {
        return "" + list ;
    }
}
