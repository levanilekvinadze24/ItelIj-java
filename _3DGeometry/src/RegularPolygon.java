public class RegularPolygon extends BaseArea {
    private int n;
    private double length;

    @Override
    public String toString() {
        return "RegularPolygon{" +
                "n=" + n +
                ", length=" + length +
                '}';
    }
    public RegularPolygon(int n,double length){
        this.n=n;
        this.length=length;
    }
    public void setn(int n){
        this.n=n;
    }
    public void setLength(double length){
        this.length=length;
    }
    public int getn(){
        return n;
    }
    public double getLength(){
        return length;
    }
    public double circumference(){
        return n*length;}
    public double area(){
        return n * Math.pow(length, 2) / (4 * Math.tan(Math.PI / n));
    }
    public boolean isSquare() {
        return n == 4;
    }
   //public Square toSquare(){//ABRUNEBS SQUAR OBIEQTS
        //if(this.isSquare()){//cheQavs
           // Square X =new Square(this.length);
         //   return new
       // }
     //   else{return null;}
   // }
   public Square toSquare() {
       if (isSquare()) {
           return new Square(length);
       } else {
           return null;
       }
   }
}
