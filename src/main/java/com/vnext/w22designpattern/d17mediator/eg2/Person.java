package com.vnext.w22designpattern.d17mediator.eg2;

/**
 * 关联类的抽象父类
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:55:42
 */
public abstract class Person {
    private String name;
    private int condition;
    private Mediator mediator;


    public Person(String name, int condition, Mediator mediator) {
        super();
        this.name = name;
        this.condition = condition;
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public abstract void getPartner(Person person);
}