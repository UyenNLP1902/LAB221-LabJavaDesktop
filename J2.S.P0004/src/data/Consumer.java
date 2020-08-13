/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author SE140355
 */
public class Consumer extends Thread {

    ProducerConsumerQueue store = null;
    
    public Consumer(ProducerConsumerQueue s) {
        store = s;
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                String result = store.getPizza();
                
                if(result != null) {
                    System.out.println("Pizza delivered: " + result);
                } else {
                    System.out.println("Waiting for new Pizza");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
