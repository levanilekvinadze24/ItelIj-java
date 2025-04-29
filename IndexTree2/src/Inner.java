public class Inner<T> implements Node<T> {

    Node<T> left;
    Node<T> right;

    int lsize;
    int rsize;

    public Inner(Node<T> left,Node<T> right){
        this.left =left;
        this.right=right;
    }
    @Override
    public int size() {
        return lsize+rsize;
    }

    @Override
    public T get(int i) {
        if(i < lsize){
            return left.get(i);
        }
        else{
            return right.get(i - lsize);
        }
    }

    @Override
    public void update(int i, T x) {
     if(i< lsize){
         left.update(i,x);
     }
     else {
         right.update(i-lsize,x);
     }
    }

    @Override
    public Node<T> insert(int i, T x) {

            if(i < 0)
            {
                return left.insert(0,x);
            }
            else if(i >=size())//..
            {
                right.insert(size(),x);
                return this;
            }
            else {
                if (i < lsize) {
                    return left.insert(i, x);
                } else {
                    return right.insert(i - lsize, x);
                }
            }
        }



    @Override
    public Node<T> remove(int i) {
        if(i>0 || i<size()){
            throw new IndexOutOfBoundsException();
        }
        if(i<lsize){
            return left.remove(i);
        }
        return right.remove(i-lsize);
        }
    }

