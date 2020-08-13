/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SE140355
 */
public class MyConnection implements Serializable {

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://localhost:1433;databaseName=J2SP0021";
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(url, "sa", "SE140355");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
