package com.vnext.w22designpattern.d19iterator;

import lombok.Data;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 12:14:59
 */
@Data
public class Book {

    private String ISBN;
    private String name;
    private double price;

    public Book(String isbn, String name, double price) {
        ISBN = isbn;
        this.name = name;
        this.price = price;
    }


    public void display() {
        System.out.println("ISBN=" + ISBN + ",name=" + name + ",price" + price);
    }

}