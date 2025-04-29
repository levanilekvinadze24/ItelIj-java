public class Rectangle extends BaseArea{
    private double width;
    private double height;


    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
    public Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
 public double circumference(){
        return 2*height+2*width;
 }
 public double area(){
        return height*width;
 }

}
