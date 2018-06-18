package com.vnext.w22designpattern.d09observer;

import java.util.Observable;
import java.util.Observer;

/**
 * ConcreteObserver观察者的具体实现 ：MediaObServer观察者
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:01:00
 */
public class MediaObServer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Article art = (Article)arg;

        System.out.println("我是MediaObServer媒体观察者...");
        System.out.println("博主发表的博客标题为：" + art.getArticleTitle());
    }
}