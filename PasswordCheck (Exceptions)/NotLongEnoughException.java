package fop.w10pass;

public class NotLongEnoughException extends NotEnoughException {

    public NotLongEnoughException(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "NotLongEnoughException: insufficient length!\n" +
                super.toString();
    }

}
