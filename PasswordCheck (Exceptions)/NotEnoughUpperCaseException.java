package fop.w10pass;

public class NotEnoughUpperCaseException extends NotEnoughLetterException {

    public NotEnoughUpperCaseException(int should, int is) {
        super(should, is);
    }

    public String toString() {
        return "NotEnoughUpperCaseException: not enough upper case letters!\n" +
                super.toString();
    }
}
