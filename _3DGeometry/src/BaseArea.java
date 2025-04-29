public abstract class BaseArea {//ar viyenbt obieqtad
    public abstract double circumference();

    public abstract double area();

    public boolean isSquare() {
        return false;//?
    }

    public Square toSquare() {
        return null;//?
    }//override xdeba

    public String toString() {
        return "circumference: " + circumference() + "; area: " + area() + "; square?: " + isSquare();//?
    }
}

