package com.vnext.w22designpattern.d23command.eg3;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:12:44
 */
public class AppleCommand extends Command {

    public AppleCommand(Peddler peddler) {
        super(peddler);
    }

    @Override
    public void sail() {
        System.out.println("AppleCommand....");
        this.getPeddler().sailApple();
    }
}