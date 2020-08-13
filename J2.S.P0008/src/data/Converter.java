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
public class Converter {

    public double convert(String cDegree) {
        double c = Double.parseDouble(cDegree);
        return (c * 1.8) + 32;
    }
}
