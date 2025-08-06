package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InternetCafeConnection {
    public void checkConnection() {
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM may_tinh WHERE trang_thai = 'san_sang'");
            rs.next();
            System.out.println("Số máy sẵn sàng: " + rs.getInt(1));
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối quán nét: " + e.getMessage());
        }
    }
}