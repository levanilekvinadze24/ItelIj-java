public class Square extends BaseArea {
    private double length;

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                '}';
    }
    public Square(double length){
        this.length=length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
public double circumference(){
        return 4*length;
}
public double area(){
        return length*length;
}



    public boolean isSquare() {
        return true;
    }
    public Square toSquare() {
        return this;
    }

    }
