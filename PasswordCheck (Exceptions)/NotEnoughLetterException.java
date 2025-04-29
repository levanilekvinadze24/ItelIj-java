package fop.w10pass;

public class NotEnoughLetterException extends NotEnoughException {

    public NotEnoughLetterException(int should, int is) {
        super(should, is);
    }

    public String toString() {
        return super.toString();
    }

}
