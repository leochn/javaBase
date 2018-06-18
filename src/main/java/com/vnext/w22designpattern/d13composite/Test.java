package com.vnext.w22designpattern.d13composite;

import java.util.List;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 18:11:42
 */
public class Test {

    /**
     * 什么是组合模式:
     *     Composite模式也叫组合模式，是构造型的设计模式之一。
     *     通过递归手段来构造树形的对象结构，并可以通过一个对象来访问整个对象树。
     *
     * 组合模式的角色和职责:
     * 1.Component （树形结构的节点抽象）
     *     - 为所有的对象定义统一的接口（公共属性，行为等的定义）
     *     - 提供管理子节点对象的接口方法
     *     - [可选]提供管理父节点对象的接口方法
     *
     * 2.Leaf （树形结构的叶节点）
     * 3.Component的实现子类
     *
     * 4.Composite（树形结构的枝节点）
     * 5.Component的实现子类
     *
     */

    public static void main(String[] args) {

        //C盘
        Folder rootFolder = new Folder("E:");
        //beifeng目录
        Folder beifengFolder = new Folder("beifeng");
        //beifeng.txt文件
        File beifengFile = new File("beifeng.txt");

        rootFolder.add(beifengFolder);
        rootFolder.add(beifengFile);

        //ibeifeng目录
        Folder ibeifengFolder = new Folder("ibeifeng");
        File ibeifengFile = new File("ibeifeng.txt");
        beifengFolder.add(ibeifengFolder);
        beifengFolder.add(ibeifengFile);

        Folder iibeifengFolder = new Folder("iibeifeng");
        File iibeifengFile = new File("iibeifeng.txt");
        ibeifengFolder.add(iibeifengFolder);
        ibeifengFolder.add(iibeifengFile);

        displayTree(rootFolder,0);


    }


    public static void displayTree(IFile rootFolder, int deep) {
        for(int i = 0; i < deep; i++) {
            System.out.print("--");
        }
        //显示自身的名称
        rootFolder.display();
        //获得子树
        List<IFile> children = rootFolder.getChild();
        //遍历子树
        for(IFile file : children) {
            if(file instanceof File) {
                for(int i = 0; i <= deep; i++) {
                    System.out.print("--");
                }
                file.display();
            } else {
                displayTree(file,deep + 1);
            }
        }
    }

}