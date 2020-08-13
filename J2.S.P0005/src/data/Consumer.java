/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author SE140355
 */
public class Consumer extends Thread implements Serializable {

    Store store = null;

    public Consumer(Store s) {
        store = s;
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                int result = store.getNumber();
                
                if(result > 0) {
                    System.out.println("Deleting whole number: " + result);
                } else {
                    System.out.print("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
