public class Main {
    public static void main(String[] args){

        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(5);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.peek());
    }
}
