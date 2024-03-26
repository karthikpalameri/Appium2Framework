package learn.designpattern.strategypattern.strategy;

public class XyzStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Xyz Drive strategy...");
    }
}
