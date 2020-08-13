/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigDecimal;
import javax.swing.JTextField;

/**
 *
 * @author SE140355
 */
public class Calculator {

    private static BigDecimal firstNum;
    private static BigDecimal secondNum;
    private static int operator = -1;
    private static BigDecimal memory = new BigDecimal("0");
    private static boolean inProcess = false;
    private static boolean reset = false;
    private JTextField screen;

    public Calculator(JTextField screen) {
        this.screen = screen;
        operator = -1;

    }

    public static void setOperator(int operator) {
        Calculator.operator = operator;
    }

    public void pressNumber(String value) {
        if (inProcess == true || reset == true) {
            screen.setText("0");
            inProcess = false;
            reset = false;
        }
        if (screen.getText().equalsIgnoreCase("0")) {
            screen.setText(value);
        } else {
            screen.setText(screen.getText() + value);
        }
    }

    public void pressClear() {
        screen.setText("0");
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");

        operator = -1;
    }
    
    private BigDecimal getValue() {
        return new BigDecimal(screen.getText());
    }
    
    public void calculate() {
        try {
            if (inProcess == false) {
                if (operator == -1) {
                    firstNum = getValue();
                } else {
                    secondNum = getValue();
                    switch (operator) {
                        case 1:
                            firstNum = firstNum.add(secondNum);
                            break;
                        case 2:
                            firstNum = firstNum.subtract(secondNum);
                            break;
                        case 3:
                            firstNum = firstNum.multiply(secondNum);
                            break;
                        case 4:
                            firstNum = firstNum.divide(secondNum);
                            break;
                    }
                }
                screen.setText(firstNum.toString());
                inProcess = true;
            }
        } catch (Exception e) {
            reset = true;
            screen.setText("ERROR");
        }
    }
    
    public void pressEqual() {
        if (!screen.getText().equalsIgnoreCase("error")) {
            calculate();
            operator = -1;
        } else {
            screen.setText(firstNum.toString());
        }
    }
}
