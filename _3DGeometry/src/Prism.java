public class Prism {
    private double height;
    private BaseArea base;//?<

    public Prism(double height, BaseArea base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public BaseArea getBase() {
        return base;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setBase(BaseArea base) {
        this.base = base;
    }
    public double surface() {
        return height * base.circumference() + 2 * base.area();
    }

    public double volume() {
        return height * base.area();
    }

         public boolean isCube() {
             if (base.isSquare()) {
                 return base.toSquare().getLength() == height;//.
             } else {
                 return false;
             }
         }

    @Override
    public String toString() {
        return "Prism{" +
                "height=" + height +
                ", base=" + base.toString() +
                '}';
    }
}



