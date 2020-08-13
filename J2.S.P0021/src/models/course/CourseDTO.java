/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.course;

/**
 *
 * @author SE140355
 */
public class CourseDTO implements Comparable<CourseDTO>{

    private String code, name;
    private int credit;

    public CourseDTO() {
    }

    public CourseDTO(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "code=" + code + ", name=" + name + ", credit=" + credit + '}';
    }

    @Override
    public int compareTo(CourseDTO o) {
        Integer c = this.credit;
        return c.compareTo(o.credit);
    }
    
}
