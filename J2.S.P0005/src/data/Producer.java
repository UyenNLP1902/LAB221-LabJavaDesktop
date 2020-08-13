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
public class Producer extends Thread implements Serializable {

    Store store = null;

    public Producer(Store s) {
        store = s;
    }

    private int getRandomNumber() {
        int min = 1;
        int max = 100;
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int number = getRandomNumber();
                boolean result = store.putNumber(number);
                if (result) {
                    System.out.println("Adding new whole number: " + number);
                } else {
                    System.out.print("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
