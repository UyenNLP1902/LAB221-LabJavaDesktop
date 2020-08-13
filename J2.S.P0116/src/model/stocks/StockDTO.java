/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stocks;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author SE140355
 */
public class StockDTO implements Serializable, Comparable<StockDTO> {

    private int id;
    private String name, address;
    private Date date;
    private String note;

    public StockDTO() {
    }

    public StockDTO(int id, String name, String address, Date date, String note) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.note = note;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        return "StockDTO{" + "id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + ", note=" + note + '}';
    }

    @Override
    public int compareTo(StockDTO o) {
        Integer n = this.id;
        return n.compareTo(o.id);
    }
}
