package learn.designpattern.commanddesignpattern;

import learn.designpattern.commanddesignpattern.command.TurnACOnCommand;

public class Main {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        MyRemoteControl myRemoteControl = new MyRemoteControl();
        //create command and press the button
        myRemoteControl.setCommand(new TurnACOnCommand(ac));
        myRemoteControl.pressButton();
        myRemoteControl.undo();
    }
}
