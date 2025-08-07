package com.example.quannet.database;

import java.sql.*;

public class InternetCafeConnection {
    public void kiemTraKetNoi() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Kết nối thành công đến CSDL quán net!");
            
            // Kiểm tra số máy đang hoạt động
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM may_tinh WHERE trang_thai = 'dang_hoat_dong'");
            rs.next();
            System.out.println("Số máy đang hoạt động: " + rs.getInt(1));
            
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}