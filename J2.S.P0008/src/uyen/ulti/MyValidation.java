/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uyen.ulti;

/**
 *
 * @author SE140355
 */
public class MyValidation {

    public static boolean checkDegree(String degree) {
        try {
            double n = Double.parseDouble(degree);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
