package fop.w9store;

public class Screw {
    private final ScrewDrive head;
    private final double diameter;
    private final double length;
    private double price;

    public Screw(ScrewDrive head, double diameter, double length,
            double price) {
        this.head = head;
        this.diameter = diameter;
        this.length = length;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {//adarebs obieqtebs
        if (obj == null || !(obj instanceof Screw))//instanceof-adarebs or obieqts
            return false;
        Screw other = (Screw) obj;
        return head == other.head && diameter == other.diameter
                && length == other.length;
    }

    /**
     * Calculates the HashCode. Note only final variables should be contained.
     * Also multiplying with and odd number ensures different hashvalues for
     * objects with swapped parameters.
     */
    @Override
    public int hashCode() {//titoel atributs amravleb kent ricxvze(7ze ziritadad da override unda)
        return head.hashCode() + 7 * Double.hashCode(diameter)
                + 49 * Double.hashCode(length);
    }

    public ScrewDrive getHead() {
        return head;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Screw [head=" + head + ", diameter=" + diameter + ", length="
                + length + ", price=" + price + "]";
    }
}