package com.vnext.w22designpattern.d17mediator.eg2;

/**
 * 具体的关联类
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:56:51
 */
public class Man extends Person {

    public Man(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    @Override
    public void getPartner(Person person) {
        this.getMediator().setMan(this);
        this.getMediator().getPartner(person);
    }
}