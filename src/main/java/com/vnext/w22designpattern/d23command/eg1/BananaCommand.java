package com.vnext.w22designpattern.d23command.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:13:36
 */
public class BananaCommand extends Command {

    public BananaCommand(Peddler peddler) {
        super(peddler);
    }

    @Override
    public void sail() {
        this.getPeddler().sailBanana();
    }
}