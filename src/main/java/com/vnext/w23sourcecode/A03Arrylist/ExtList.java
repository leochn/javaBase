package com.vnext.w23sourcecode.A03Arrylist;

/**
 * @Auther: LEO
 * @Date: 2019/3/9 07:21
 * @Description:
 */
public interface ExtList<E> {

    public void add(E object);

    public void add(int index, E object);

    public Object remove(int index);

    public boolean remove(E object);

    public int getSize();

    public Object get(int index);
}
