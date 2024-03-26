package learn.designpattern.strategypattern;

import learn.designpattern.strategypattern.strategy.NormalDriveStrategy;

public class NormalVehicleChild extends VehicleParent {
    NormalVehicleChild() {
        super(new NormalDriveStrategy());
    }
}
