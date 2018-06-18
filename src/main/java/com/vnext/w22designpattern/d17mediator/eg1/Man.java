package com.vnext.w22designpattern.d17mediator.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:50:41
 */
public class Man extends Person {

    public Man(String name, int condition) {
        super(name, condition);
    }

    @Override
    public void getPartner(Person person) {
        if(person instanceof Man) {
            System.out.println(person.getName() + "说：汗，我不是同性恋！baibai...");
        } else {
            if(this.getCondition() == person.getCondition()) {
                System.out.println(this.getName() + "和" + person.getName() + "绝配");
            } else {
                System.out.println(this.getName() + "和" + person.getName() + "不相配");
            }
        }
    }
}