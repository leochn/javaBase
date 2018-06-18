package com.vnext.w22designpattern.d13composite;

import java.util.List;

/**
 * 文件节点抽象(是文件和目录的父类)
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 18:14:11
 */
public interface IFile {

    //显示文件或者文件夹的名称
    void display();

    //添加
    boolean add(IFile file);

    //移除
    boolean remove(IFile file);

    //获得子节点
    List<IFile> getChild();
}