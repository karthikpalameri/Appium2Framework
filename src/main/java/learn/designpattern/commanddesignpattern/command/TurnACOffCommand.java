package learn.designpattern.commanddesignpattern.command;

import learn.designpattern.commanddesignpattern.AirConditioner;

public class TurnACOffCommand implements ICommand {
    AirConditioner ac;

    public TurnACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.setOffAc();
    }

    @Override
    public void undo() {
        ac.setOnAc();
    }
}
