package com.vnext.w22designpattern.d19iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 12:12:35
 */
public class Test {

    /**
     * 什么是迭代模式:
     *     是行为模式之一，它把对容器中包含的内部对象的访问委让给外部类，使用Iterator（遍历）按顺序进行遍历访问的设计模式。
     */


    public static void main(String[] args) {
        BookList bookList = new BookList();

        Book book1 = new Book("010203","Java编程思想",90);
        Book book2 = new Book("010204","Java从入门到精通",60);

        bookList.addBook(book1);
        bookList.addBook(book2);

//		while(bookList.hasNext()) {
//			Book book = bookList.getNext();
//			book.display();
//		}

        System.out.println("-------------------");

		List<Book> bookDateList = bookList.getBookList();
		for(int i = 0; i < bookDateList.size(); i++) {
			Book book = bookDateList.get(i);
			book.display();
		}

        System.out.println("-------------------");
        Iterator iter = bookList.Iterator();
        while(iter.hasNext()) {
            Book book = (Book) iter.next();
            book.display();
        }


    }

}