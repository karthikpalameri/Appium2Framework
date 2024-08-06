package learn.designpattern.nullobjectpattern;

public class Bike implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 5;
    }

    @Override
    public int getSeatingCapacity() {
        return 2;
    }
}
