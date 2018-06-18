package com.vnext.w22designpattern.d23command.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:12:11
 */
public abstract class Command {

    private Peddler peddler;


    public Command(Peddler peddler) {
        this.peddler = peddler;
    }

    public Peddler getPeddler() {
        return peddler;
    }

    public void setPeddler(Peddler peddler) {
        this.peddler = peddler;
    }

    public abstract void sail();
}