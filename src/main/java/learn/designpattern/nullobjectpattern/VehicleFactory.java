package learn.designpattern.nullobjectpattern;

public class VehicleFactory {
    public static Vehicle getVehicleObject(String typeOfVehicle) {
        if (typeOfVehicle.equalsIgnoreCase("car")) {
            return new Car();
        }
        return new NullVehicle();
    }
}
