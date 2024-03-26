package learn.designpattern.strategypattern;

import learn.designpattern.strategypattern.strategy.DriveStrategy;

public class VehicleParent {
    DriveStrategy driveStrategy;

    VehicleParent(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
   
}
