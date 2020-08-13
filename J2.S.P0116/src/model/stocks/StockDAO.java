/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stocks;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import uyen.ulti.MyValidation;

/**
 *
 * @author SE140355
 */
public class StockDAO {

    Connection conn;
    PreparedStatement stm;
    ResultSet rs;

    public StockDAO() {
    }

    public StockDAO(Connection conn, PreparedStatement stm, ResultSet rs) {
        this.conn = conn;
        this.stm = stm;
        this.rs = rs;
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<StockDTO> generateData() throws ParseException {
        List<StockDTO> result = new ArrayList<>();
        StockDTO dto = null;
        for (int i = 1; i <= 5; i++) {
            String name = "Stock " + MyValidation.convertNumber(i);
            String address = MyValidation.generateString(15);
            Date date = MyValidation.generateDate();
            String note = MyValidation.generateString(20);

            dto = new StockDTO(i, name, address, date, note);
            result.add(dto);
        }
        return result;
    }

    public List<StockDTO> getAllStocks() throws Exception {
        List<StockDTO> result = null;
        StockDTO dto = null;
        try {
            String sql = "SELECT * "
                    + "FROM Stocks";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("StockID");
                String name = rs.getString("StockName");
                String address = rs.getString("String");
                Date date = rs.getDate("DateAvailable");
                String note = rs.getString("Note");

                dto = new StockDTO(id, name, address, date, note);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public boolean insertToDatabase(int id, String name, String address,
            Date date, String note) throws Exception {
        boolean check = false;
        try {
            String url = "INSERT INTO Stocks(StockID, StockName, Address, DateAvailable, Note) "
                    + "VALUES(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            conn.setAutoCommit(false);
            stm = conn.prepareStatement(url);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setString(3, address);
            stm.setDate(4, date);
            stm.setString(5, note);

            check = stm.executeUpdate() > 0;
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            closeConnection();
        }
        return check;
    }
}
