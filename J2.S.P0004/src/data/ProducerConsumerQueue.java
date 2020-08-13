/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author SE140355
 */
public class ProducerConsumerQueue {

    private Queue<String> list = null;

    public ProducerConsumerQueue() {
        this.list = new LinkedList<>();
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

    public synchronized boolean putPizza(String pizza) {
        if (pizza == null) {
            return false;
        }
        if (!list.offer(pizza)) {
            return false;
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public synchronized String getPizza() {
        String s = null;
        if (!isEmpty()) {
            s = list.poll();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    //==============================================
}
