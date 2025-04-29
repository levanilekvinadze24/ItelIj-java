import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexedTree<T> implements Iterable<T> {
    private Node<T> tree;

    public int size() {
        if (tree == null) return 0;
        return tree.size();
    }

    public T get(int i) {
        if (tree == null) return null;
        return tree.get(i);
    }

    public void update(int i, T x) {
        tree.update(i, x);
    }

    public void insert(int i, T x) {
        if (tree == null) tree = new Leaf<>(x);
        tree.insert(i, x);
    }

    public void remove(int i) {
        tree.remove(i);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;
            Node<T> next = tree;

            @Override
            public boolean hasNext() {
                return next != null;
            }
        };
    }

    ;
}