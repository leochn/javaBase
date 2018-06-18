package com.vnext.w22designpattern.d23command.eg3;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务员，管理command集合
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:19:12
 */
public class Waiter {

    private List<Command> commands = new ArrayList<Command>();


    public void setOrder(Command command) {
        commands.add(command);
    }

    public void removeOrder(Command command) {
        commands.remove(command);
    }

    public void sail() {
        for(Command command : commands) {
            command.sail();
        }
    }
}