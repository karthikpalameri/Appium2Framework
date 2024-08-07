package learn.designpattern.commanddesignpattern;

import com.google.common.base.MoreObjects;
import learn.designpattern.commanddesignpattern.command.ICommand;

import java.util.Stack;

//1.INVOKER
public class MyRemoteControl {
    ICommand command;
    Stack<ICommand> acCommandHistory = new Stack<>();

    MyRemoteControl() {
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        System.out.println("Adding the command to the acCommandHistory stack..");
        acCommandHistory.add(command);
    }

    public void undo() {
        if (!acCommandHistory.isEmpty()) {
            ICommand lastCommand = acCommandHistory.pop();
            lastCommand.undo();
        }
    }
}

