/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.Consumer;
import data.Producer;
import data.Store;

/**
 *
 * @author SE140355
 */
public class Main {
    
    Store store;
    Producer pro;
    Consumer con;
    
    public Main() {
        store = new Store();
        pro = new Producer(store);
        con = new Consumer(store);
        pro.start();
        con.start();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
