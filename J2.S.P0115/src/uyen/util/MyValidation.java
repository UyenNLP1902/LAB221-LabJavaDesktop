/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author SE140355
 */
public class MyValidation {

    private static final String CODE_VALID = "[A-Za-z0-9]{1,10}";
    private static final String NAME_VALID = "[A-Za-z0-9 ]{1,30}";
    private static final String PHONE_VALID = "[0-9]{1,15}";
    private static final String EMAIL_VALID = "[A-Za-z0-9._-]{1,15}[@]{1}[A-Za-z0-9.]{1,14}";

    public static boolean checkCode(String code) {
        return code.matches(CODE_VALID);
    }
    
    public static boolean checkName(String name) {
        return name.matches(NAME_VALID);
    }
    
    public static boolean checkDate(String date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);
        try {
            df.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE_VALID);
    }
    
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL_VALID);
    }
}
