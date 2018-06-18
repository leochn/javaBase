package com.vnext.w22designpattern.d09observer;

import java.util.Observable;
import java.util.Observer;

/**
 * ConcreteObserver观察者的具体实现 ：MyObServer观察者
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 11:33:33
 */
public class MyObServer implements Observer {

    /**
     * 被观察者通知观察者之后,观察者执行该方法
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        Article art = (Article)arg;

        System.out.println("我是MyObServer观察者...");
        System.out.println("博主发表了新的文章，快去看吧!");
        System.out.println("博客标题为：" + art.getArticleTitle());
        System.out.println("博客内容为:" + art.getArticleContent());
    }
}