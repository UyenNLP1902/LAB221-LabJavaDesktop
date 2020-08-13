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
public class Stock implements Comparable<Stock> {

    private String id, name, address, date, note;

    public Stock(String id, String name, String address, String date, String note) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.note = note;
    }

    public Stock() {
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(address);
        v.add(date);
        v.add(note);
        return v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + ", note=" + note + '}';
    }

    @Override
    public int compareTo(Stock o) {
        return this.id.compareToIgnoreCase(o.id);
    }

}
