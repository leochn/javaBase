package com.vnext.w22designpattern.d13composite;

import java.util.List;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 18:14:55
 */
public class File implements IFile {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile file) {
        return false;
    }

    @Override
    public boolean remove(IFile file) {
        return false;
    }

    @Override
    public List<IFile> getChild() {
        return null;
    }
}