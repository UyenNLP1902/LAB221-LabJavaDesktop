/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Queue;

/**
 *
 * @author SE140355
 */
public class Producer extends Thread {

    ProducerConsumerQueue store = null;
    Queue<String> list = null;

    public Producer(ProducerConsumerQueue s, Queue<String> list) {
        store = s;
        this.list = list;
    }
    
    private String madePizza() {
        if (!list.isEmpty()) {            
            return list.poll();
        }
        
        return null;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String pizza = madePizza();
                boolean result = store.putPizza(pizza);
                if (result) {
                    System.out.println("New Pizza is ready: " + pizza);
                } else {
                    System.out.println("No more pizza");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
