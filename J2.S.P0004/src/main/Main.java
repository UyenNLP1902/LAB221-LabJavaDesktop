/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author SE140355
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    Queue<String> list = null;
    ProducerConsumerQueue store;
    Producer pro;
    Consumer con;

    public Main(String list) {
        this.list = getListPizza(list);
        store = new ProducerConsumerQueue();
        pro = new Producer(store, this.list);
        con = new Consumer(store);
        pro.start();
        con.start();
    }
    
    
    
    public static void main(String[] args) {
        String list = getString("Enter the list of pizza which are provided by restaurant "
                + "(seperate by comma): ");
        Main main = new Main(list);
    }
    
    //==============================================================
    
    private static String getString(String inMsg) {
        String n;
        while (true) {
            System.out.print(inMsg);
            n = sc.nextLine().trim();
            if (n.length() == 0 || n.isEmpty()) {
                System.out.println("Error");
            } else {
                return n;
            }
        }
    }
    
    private static Queue getListPizza(String s) {
        Queue<String> list = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(s, ",");
        while (stk.hasMoreElements()) {
            list.add(stk.nextToken().trim());
        }
        return list;
    }
}
