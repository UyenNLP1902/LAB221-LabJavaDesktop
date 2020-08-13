/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Vector;

/**
 *
 * @author SE140355
 */
public class Book implements Comparable<Book>{

    private String code, name, author, publisher;
    int year;
    boolean rent;

    public Book() {
    }

    public Book(String code, String name, String author, String publisher, int year, boolean rent) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.rent = rent;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(code);
        v.add(name);
        return v;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Book{" + "code=" + code + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", year=" + year + ", rent=" + rent + '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.code.compareToIgnoreCase(o.code);
    }

}
