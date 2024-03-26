package learn.designpattern.strategypattern;

import learn.designpattern.strategypattern.strategy.DriveStrategy;
import learn.designpattern.strategypattern.strategy.SportsDriveStrategy;

public class OffroadVehicleChild extends VehicleParent {

    OffroadVehicleChild(DriveStrategy driveStrategy) {
        super(new SportsDriveStrategy());
    }
}
