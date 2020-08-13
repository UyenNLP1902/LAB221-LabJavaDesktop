/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Stack;

/**
 *
 * @author SE140355
 */
public class Store implements Serializable {

    int maxN = 5;
    Stack<Integer> stk = null;
    boolean ready = false;

    public Store() {
        stk = new Stack<>();
    }

    private boolean isEmpty() {
        return stk.isEmpty();
    }

    private boolean isFull() {
        return stk.size() == maxN;
    }

    public synchronized boolean putNumber(int n) {
        if (isFull()) {
            ready = true;
            return false;
        } 
        if (ready == true) {
            return false;
        }

        stk.add(n);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public synchronized int getNumber() {
        int result = 0;
        if (!isEmpty() && ready == true) {
            result = stk.pop();
            if (stk.size() == 2) {
                ready = false;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
