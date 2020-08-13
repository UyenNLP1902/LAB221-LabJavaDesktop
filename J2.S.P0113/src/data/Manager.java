/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SE140355
 */
public class Manager extends FileNotFoundException {

    private static final List<Book> bookList = new LinkedList<>();

    public Manager() {
        try {
            loadFile("data.dat");
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        try {
            saveFile("data.dat");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Book> getAllBook() {
        return bookList;
    }

    public boolean create(String code, String name, String author,
            String publisher, int year, boolean isRent) {
        boolean check = false;
        if (searchBookCode(code) != null) {
            return check;
        }
        check = bookList.add(new Book(code, name, author, publisher, year, isRent));
        return check;
    }

    public Book searchByPrimaryKey(String code) {
        return searchBookCode(code);
    }

    public void update(String code, String name, String author,
            String publisher, int year, boolean isRent) {
        Book book = searchBookCode(code);
        book.setName(name);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setYear(year);
        book.setRent(isRent);
    }

    public boolean delete(String code) {
        boolean check;
        Book book = searchBookCode(code);
        check = bookList.remove(book);
        return check;
    }

    //============================================
    private Book searchBookCode(String code) {
        if (bookList.isEmpty()) {
            return null;
        }

        for (Book book : bookList) {
            if (code.equalsIgnoreCase(book.getCode())) {
                return book;
            }
        }
        return null;
    }

    private void saveFile(String fileName) throws FileNotFoundException {
        try (PrintWriter pr = new PrintWriter(fileName)) {
            for (Book book : bookList) {
                int isRent;
                if (book.isRent() == true) {
                    isRent = 1;
                } else {
                    isRent = 0;
                }
                String s = book.getCode() + "," + book.getName() + ","
                        + book.getAuthor() + "," + book.getPublisher() + ","
                        + book.getYear() + "," + isRent;
                pr.println(s);
            }
            pr.close();
        }
    }

    private void loadFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                String code = stk.nextToken().trim();
                String name = stk.nextToken().trim();
                String author = stk.nextToken().trim();
                String publisher = stk.nextToken().trim();
                int year = Integer.parseInt(stk.nextToken().trim());
                int rent = Integer.parseInt(stk.nextToken().trim());
                boolean isRent;
                if (rent == 0) {
                    isRent = false;
                } else {
                    isRent = true;
                }

                bookList.add(new Book(code, name, author, publisher, year, isRent));
            }
        }
    }
}
