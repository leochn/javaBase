package com.vnext.w22designpattern.d13composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 18:16:08
 */
public class Folder implements IFile {
    private String name;
    private List<IFile> children;

    public Folder(String name) {
        this.name = name;
        children = new ArrayList<IFile>();
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile file) {
        return children.add(file);
    }

    @Override
    public boolean remove(IFile file) {
        return children.remove(file);
    }

    @Override
    public List<IFile> getChild() {
        return children;
    }
}