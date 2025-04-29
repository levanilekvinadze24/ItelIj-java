package pgdp.collections;

public class StackConnector<T> implements DataStructureConnector<T> {
    private Stack<T> stack;

    public StackConnector(Stack<T> stack) {
        if (stack == null)
            ExceptionUtil.illegalArgument("Stack must not be null");
        this.stack = stack;
    }

    @Override
    public boolean hasNextElement() {
        return !stack.isEmpty();
    }

    @Override
    public void addElement(T t) {
        stack.push(t);
    }

    @Override
    public T removeNextElement() {
        return stack.pop();
    }
}