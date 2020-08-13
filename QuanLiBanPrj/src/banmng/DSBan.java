/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banmng;

import java.util.ArrayList;
import java.util.Collections;
import uyen.ulti.InputTool;

/**
 *
 * @author SE140355
 */
public class DSBan extends ArrayList<Ban> {

    public DSBan() {
        super();
    }

    public int find(String s) {
        for (int i = 0; i < this.size(); i++) {
            if (s.equalsIgnoreCase(this.get(i).getMa()) == true) {
                return i;
            }
        }
        return -1;
    }

    public void add() {
        String code, name;
        int price;
        int pos;

        do {
            code = InputTool.getString("Nhap ma: ", "Xin nhap lai!");
            pos = this.find(code);
            if (pos != -1) {
                System.out.println("Ma da ton tai!");
            }
        } while (pos != -1);

        name = InputTool.getString("Nhap ten: ", "Xin nhap lai!");

        price = InputTool.getAnInteger("Nhap gia: ", "Xin nhap lai!");

        if (this.add(new Ban(code, name, price))) {
            System.out.println("Da them thanh cong!");
        }
    }

    public void delete() {
        String code;
        int pos;

        code = InputTool.getString("Nhap ma: ", "Xin nhap lai!");
        pos = this.find(code);
        if (pos == -1) {
            System.out.println("San pham khong ton tai!");
        } else {
            if (this.remove(pos) != null) {
                System.out.println("Da xoa thanh cong!");
            }
        }
    }

    public void editPrice() {
        String code;
        int price, pos;

        code = InputTool.getString("Nhap ma: ", "Xin nhap lai!");
        pos = this.find(code);
        if (pos == -1) {
            System.out.println("San pham khong ton tai!");
        } else {
            Ban b = this.get(pos);
            System.out.println("Gia cu: " + b.getGia());
            price = InputTool.getAnInteger("Nhap gia moi: ", "Xin nhap lai!");
            
            b.setGia(price);
            System.out.println("Da sua thanh cong!");
        }
    }

    public void printAll() {
        Collections.sort(this);
        for (Ban ban : this) {
            System.out.println(ban);
        }
    }

}
