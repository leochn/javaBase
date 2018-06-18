package com.vnext.w22designpattern.d09observer;

import java.util.Observable;

/**
 * Subject（被观察者）:
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 11:33:11
 */
public class BlogUser extends Observable {

    /**
     * 被观察者发布博客
     * @param articleTitle 文章主题
     * @param articleContent 文章内容
     */
    public void publishBlog(String articleTitle, String articleContent) {
        Article art = new Article();
        art.setArticleTitle(articleTitle);
        art.setArticleContent(articleContent);
        System.out.println("大家好，我是博主，今天发表了新文章。标题为:" + articleTitle + ",内容:" + articleContent);

        // 设置对象改变
        this.setChanged();
        // 通知其他所有的观察者
        this.notifyObservers(art);
    }
}