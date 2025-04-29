package fop.w10pass;

public class NotEnoughException extends Exception {

    private final int should;
    private final int is;

    public NotEnoughException(int should, int is) {
        if (is >= should) {
            throw new IllegalArgumentException();
        }
        this.should = should;
        this.is = is;
    }

    public String toString() {
        return "Should: " + should + ", but is " + is + "!";
    }

}
