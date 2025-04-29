public class ListImpl {
    private int info;
    private ListImpl next;


    public ListImpl(int x) {
        info = x;
    }

    public ListImpl(int x, ListImpl l) {
        info = x;
        next = l;
    }


    public void insert(int x) {
        next = new ListImpl(x, next);
    }

    public void delete() {
        if (next != null)
            next = next.next;
    }

    public int length() {
        int result = 1;
        for (ListImpl t = next; t != null; t = t.next)
            result++;
        return result;
    }

    public int getInfo() {
        return info;
    }

    public ListImpl getNext() {
        return next;
    }

    @Override
    public String toString() {
        String result = "[" + info;
        for (ListImpl t = next; t != null; t = t.next)
            result = result + ", " + t.info;
        return result + "]";
    }
}
