/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.ulti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Random;

/**
 *
 * @author SE140355
 */
public class MyValidation {

    final static String DATE_FORMAT = "yyyy-MM-dd";
    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five"
    };

    public static boolean checkDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String convertNumber(int number) {
        return numNames[number];
    }

    public static String generateString(int length) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static Date generateDate() throws ParseException {
        Long max = 0L;
        Long min = 100000000000L;

        Random r = new Random();
        Long randomLong = (r.nextLong() % (max - min)) + min;
        java.util.Date dt = new Date(randomLong);
        Date date = new Date(dt.getTime());
        return date;

    }
}
