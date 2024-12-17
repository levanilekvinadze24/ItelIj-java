public class Stack {
    private List l;

    public Stack() {
        l = null;
    }

    public boolean isEmpty() {
        return l == null;
    }

    public int pop() {
        int result = l.info;
        l = l.next;
        return result;
    }
    public void push(int a){
        l = new List( a , l);
    }
    public String toString(){
        return List.toString(l);
    }

}