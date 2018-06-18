package com.vnext.w22designpattern.d21memento;

/**
 * Caretaker（管理者）:负责在适当的时间保存/恢复Originator对象的状态。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 13:49:39
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}