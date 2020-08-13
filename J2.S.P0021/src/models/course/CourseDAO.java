/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.course;

import conn.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SE140355
 */
public class CourseDAO {

    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;

    public CourseDAO() {
    }

    public CourseDAO(Connection conn, PreparedStatement stm, ResultSet rs) {
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

    public CourseDTO searchByPrimaryKey(String code) throws Exception {
        CourseDTO dto = null;

        try {
            String sql = "SELECT * "
                    + "FROM tblInfo "
                    + "WHERE Code = ?";
            conn = MyConnection.openConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, code);
            rs = stm.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Name");
                int credit = rs.getInt("Credit");
                dto = new CourseDTO(code, name, credit);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public List<CourseDTO> displayAllCourses() throws Exception {
        List<CourseDTO> result = null;
        CourseDTO dto = null;

        try {
            String sql = "SELECT * "
                    + "FROM tblInfo";
            conn = MyConnection.openConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            result = new ArrayList<>();
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                int credit = rs.getInt("Credit");

                dto = new CourseDTO(code, name, credit);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean addCourse(String code, String name, int credit) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblInfo(Code, Name, Credit) "
                    + "VALUES(?,?,?)";
            conn = MyConnection.openConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, code);
            stm.setString(2, name);
            stm.setInt(3, credit);

            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
