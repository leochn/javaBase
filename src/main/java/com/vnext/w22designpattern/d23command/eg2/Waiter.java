package com.vnext.w22designpattern.d23command.eg2;

/**
 * 服务员
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:19:12
 */
public class Waiter {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void sail() {
        command.sail();
    }
}