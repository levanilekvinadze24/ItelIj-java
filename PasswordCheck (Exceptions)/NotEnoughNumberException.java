package fop.w10pass;

public class NotEnoughNumberException extends NotEnoughException {

    public NotEnoughNumberException(int should, int is) {
        super(should, is);
    }

    public String toString() {
        return "NotEnoughNumberException: not enough numbers!\n" +
                super.toString();
    }

}
