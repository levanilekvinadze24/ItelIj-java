package pgdp.collections;

public class PenguinSupermarket {
    private Checkout[] checkouts;

    public PenguinSupermarket(int numCheckouts) {
        if (numCheckouts <= 0)
            ExceptionUtil.illegalArgument("numCheckouts must not be negative or zero: " + numCheckouts);
        this.checkouts = new Checkout[numCheckouts];
        for (int i = 0; i < checkouts.length; i++) {
            checkouts[i] = new Checkout();
        }
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public Checkout getCheckoutWithSmallestQueue() {
        Checkout smallest = null;
        for (Checkout checkout : checkouts) {
            if (smallest == null || smallest.queueLength() > checkout.queueLength())
                smallest = checkout;
        }
        return smallest;
    }

    public void serveCustomers() {
        for (Checkout checkout : checkouts) {
            checkout.serveNextCustomer();
        }
    }

    public void closeCheckout(int index) {
        if (index < 0 || index >= checkouts.length)
            ExceptionUtil.illegalArgument("invalid index: " + index);
        if (checkouts.length == 1)
            ExceptionUtil.illegalArgument("cannot close last Checkout");
        Checkout closed = checkouts[index];
        Checkout[] smallerCopy = new Checkout[checkouts.length - 1];
        for (int i = 0; i < smallerCopy.length; i++) {
            smallerCopy[i] = checkouts[i >= index ? i + 1 : i];
        }
        checkouts = smallerCopy;
        closed.close(this);
    }
}