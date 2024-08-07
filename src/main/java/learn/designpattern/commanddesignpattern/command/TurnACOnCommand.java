package learn.designpattern.commanddesignpattern.command;

import learn.designpattern.commanddesignpattern.AirConditioner;

public class TurnACOnCommand implements ICommand {
    AirConditioner ac;

    public TurnACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.setOnAc();
    }

    @Override
    public void undo() {
        ac.setOffAc();
    }
}
