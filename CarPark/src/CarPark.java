import java.util.Arrays;

public class CarPark {
    public static Car[] spaces;


    public CarPark(int n ){
        spaces = new Car[n];
    }
    public int park(Car c){

            

        return -1;
    }


    @Override
    public String toString() {
        return "CarPark{" +
                "spaces=" + Arrays.toString(spaces) +
                '}';
    }
