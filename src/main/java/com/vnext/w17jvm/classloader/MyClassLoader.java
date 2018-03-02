package com.vnext.w17jvm.classloader;

/**
 * @author leo
 * @version 2018/3/1 20:17
 * @since 1.0.0
 */
public class MyClassLoader extends ClassLoader{

    private String name;           // 类加载器的名字
    private String path = "d:\\";  // 加载类的路径
    private final String fileType = ".class"; // class文件的扩展名

    public MyClassLoader(){

    }

    public MyClassLoader(String name) {
        super(); // 让系统类加载器成为该类加载器的父类加载器
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent); // 显示指定该类加载器的父加载器
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
