/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banmng;

/**
 *
 * @author SE140355
 */
public class Ban implements Comparable<Ban> {

    private String ma = "";
    private String ten = "";
    private int gia = 0;

    public Ban() {
    }

    public Ban(String ma, String ten, int gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "ma=" + ma + ", ten=" + ten + ", gia=" + gia;
    }

    @Override
    public int compareTo(Ban o) {
        return this.ma.compareToIgnoreCase(o.ma);
    }
}
