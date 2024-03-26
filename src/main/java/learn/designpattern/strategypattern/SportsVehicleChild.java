package learn.designpattern.strategypattern;

import learn.designpattern.strategypattern.strategy.SportsDriveStrategy;

public class SportsVehicleChild extends VehicleParent {
    SportsVehicleChild() {
        super(new SportsDriveStrategy());
    }
}
