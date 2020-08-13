/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SE140355
 */
public class Manager extends FileNotFoundException {

    private static final List<Stock> stockList = new LinkedList<>();

    public Manager() {
        try {
            loadFile("data.dat");
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        try {
            saveFile("data.dat");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Stock> getAllStocks() {
        return stockList;
    }

    //============================================
    private void saveFile(String fileName) throws FileNotFoundException {
        try (PrintWriter pr = new PrintWriter(fileName)) {
            for (Stock stock : stockList) {

                String s = stock.getId() + "," + stock.getName() + ","
                        + stock.getAddress() + "," + stock.getDate() + ","
                        + stock.getNote();
                pr.println(s);
            }
            pr.close();
        }
    }

    private void loadFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                String id = stk.nextToken().trim();
                String name = stk.nextToken().trim();
                String address = stk.nextToken().trim();
                String date = stk.nextToken().trim();
                String note = stk.nextToken().trim();
                if (note.equalsIgnoreCase("N/A")) {
                    note = "";
                }

                stockList.add(new Stock(id, name, address, date, note));
            }
        }
    }
}
