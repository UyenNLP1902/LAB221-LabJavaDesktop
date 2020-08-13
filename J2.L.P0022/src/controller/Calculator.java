/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    private static boolean isMR = false;

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
        isMR = false;
        if (screen.getText().equalsIgnoreCase("0")) {
            screen.setText(value);
        } else {
            screen.setText(screen.getText() + value);
        }

    }

    public void pressDot() {
        if (inProcess == true || reset == true) {
            screen.setText("0");
            inProcess = false;
            reset = false;
        }

        if (!screen.getText().contains(".")) {
            screen.setText(screen.getText() + ".");
        }
    }

    public void pressAllClear() {
        screen.setText("0");
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");

        operator = -1;
    }

    private BigDecimal getValue() {
        if (isMR) {
            return memory;
        }
        return new BigDecimal(screen.getText());
    }

    public void pressEqual() {
        if (!screen.getText().equalsIgnoreCase("error")) {
            calculate();
            operator = -1;
        } else {
            screen.setText(firstNum.toString());
        }
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

    public void pressNegate() {
        try {
            operator = -1;
            screen.setText(getValue().negate().toString());
            inProcess = false;
        } catch (Exception e) {
            screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressInvert() {
        try {
            operator = -1;
            double result = getValue().doubleValue();
            Double tmp = 1 / result;
            DecimalFormat df = new DecimalFormat("0.000");
            if (result != 0) {
                screen.setText(df.format(tmp));
                inProcess = false;
            }
        } catch (Exception e) {
            screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressPercent() {
        try {
            operator = -1;
            Double tmp = getValue().doubleValue() / 100;
            screen.setText(tmp.toString());
            inProcess = false;
        } catch (Exception e) {
            screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressSqrt() {
        try {
            operator = -1;
            BigDecimal tmp = getValue();
            if (tmp.doubleValue() >= 0) {
                Double result = Math.sqrt(tmp.doubleValue());
                String display = result.toString();

                if (display.endsWith(".0")) {
                    display = display.replace(".0", "");
                }

             //   DecimalFormat df = new DecimalFormat("0.000");

                screen.setText(display);
                inProcess = false;
            } else {
                screen.setText("ERROR");
            }
        } catch (Exception e) {
            screen.setText("ERROR");
        }
        reset = true;
    }

    //Memory manipulate
    public void pressMR() {
        screen.setText(memory.toString());
        isMR = true;
    }

    public void pressMClear() {
        memory = new BigDecimal("0");
        screen.setText("0");
    }

    public void pressMAdd() {
        try {
            memory = memory.add(getValue());
            inProcess = false;
        } catch (Exception e) {
            screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressMSub() {
        try {
            memory = memory.subtract(getValue());
            inProcess = false;
        } catch (Exception e) {
            screen.setText("ERROR");
        }
        reset = true;
    }
}
