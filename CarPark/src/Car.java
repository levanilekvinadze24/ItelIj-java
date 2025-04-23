public class Car {
    private String brand;
    private LicensePlate licensePlate;

    private static int chassisnumber;

    public Car(String brand, LicensePlate licensePlate) {

        this.brand = brand;
        this.licensePlate = licensePlate;
        this.chassisnumber =  chassisnumber++;

    }
}


