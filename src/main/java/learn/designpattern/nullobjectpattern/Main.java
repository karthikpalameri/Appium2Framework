package learn.designpattern.nullobjectpattern;

public class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicleObject("car");
        System.out.println("car.getTankCapacity() = " + car.getTankCapacity());
        System.out.println("car.getSeatingCapacity() = " + car.getSeatingCapacity());

        Vehicle xyz = VehicleFactory.getVehicleObject("xyz");
        System.out.println("xyz.getSeatingCapacity() = " + xyz.getSeatingCapacity());
        System.out.println("xyz.getTankCapacity() = " + xyz.getTankCapacity());
    }
}
