package fop.w10pass;

public class NotEnoughSpecialException extends NotEnoughException {

    public NotEnoughSpecialException(int should, int is) {
        super(should, is);
    }

    public String toString() {
        return "NotEnoughSpecialException: not enough special characters!\n" +
                super.toString();
    }
}
