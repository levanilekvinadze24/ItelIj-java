public class Circle extends BaseArea {
    private double radius;//-

    @Override
    public String toString() {//+
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
    public Circle(double radius){//constructor ro shemqna
        this.radius=radius;
    }

    public void setRadius(double radius) {//seter
        this.radius = radius;
    }

    public double getRadius() {//geter
        return radius;
    }
    public double circumference() {
        return 2 * Math.PI * radius;
    }
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
