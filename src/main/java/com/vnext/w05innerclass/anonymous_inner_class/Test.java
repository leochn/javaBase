package com.vnext.w05innerclass.anonymous_inner_class;

/**
 * 匿名内部类
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 19:44:36
 */
public class Test {

    public void testBird(Bird bird){
        System.out.println(bird.getName() + "能够飞" + bird.fly() + "米!");
    }

    public void testPerson(Person person){
        System.out.println(person.say("how are you?"));
    }

    public void testStudent(IStudent student){
        System.out.println(student.show("what?"));
    }

    public static void main(String[] args) {
        /**
         * 1.使用匿名内部类我们必须要继承一个父类或者实现一个接口，当然也仅能只继承一个父类或者实现一个接口
         * 2.由于匿名内部类不能是抽象类，所以它必须要实现它的抽象父类或者接口里面所有的抽象方法
         */

        Test test = new Test();
        test.testBird(new Bird() {
            @Override
            public int fly() {
                return 100;
            }
            @Override
            public String getName() {
                return "大雁";
            }
        });

        System.out.println("----------------");
        test.testPerson(new Person());
        System.out.println("----------------");
        test.testStudent(new IStudent() {
            @Override
            public String show(String string) {
                return "student show ---> " + string;
            }
        });
    }



}