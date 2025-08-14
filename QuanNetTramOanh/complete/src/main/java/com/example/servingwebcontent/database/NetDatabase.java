package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NetDatabase {
    private Connection conn;
    
    public NetDatabase() {
        // Khởi tạo kết nối khi tạo đối tượng
        connectToDatabase();
    }
    
    /**
     * Thiết lập kết nối đến database quán net
     */
    private void connectToDatabase() {
        try {
            // Thay đổi thông tin kết nối cho phù hợp với cấu hình của bạn
            String url = "jdbc:mysql://localhost:3306/netcafe";
            String user = "root";
            String password = "your_password";
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("Đã kết nối thành công đến database quán net!");
        } catch (Exception e) {
            System.err.println("Lỗi kết nối database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Lấy danh sách máy tính trong quán
     */
    public void displayComputers() {
        try (Statement sta = conn.createStatement();
             ResultSet rs = sta.executeQuery("SELECT * FROM may_tinh WHERE trang_thai = 'active'")) {
            
            System.out.println("\nDANH SÁCH MÁY TÍNH:");
            System.out.println("----------------------------------------");
            System.out.printf("| %-8s | %-15s | %-12s |\n", "Mã máy", "Tên máy", "Giá/giờ");
            System.out.println("----------------------------------------");
            
            while (rs.next()) {
                String maMay = rs.getString("ma_may");
                String tenMay = rs.getString("ten_may");
                int giaGio = rs.getInt("gia_gio");
                System.out.printf("| %-8s | %-15s | %12s |\n", 
                                 maMay, tenMay, formatCurrency(giaGio));
            }
            System.out.println("----------------------------------------");
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách máy: " + e.getMessage());
        }
    }
    
    /**
     * Lấy danh sách khách hàng đang sử dụng máy
     */
    public void displayActiveCustomers() {
        String sql = "SELECT k.ma_khach, k.ten_khach, k.so_dt, m.ten_may, " +
                     "t.gio_bat_dau, t.gio_ket_thuc " +
                     "FROM khach_hang k " +
                     "JOIN thoi_gian_su_dung t ON k.ma_khach = t.ma_khach " +
                     "JOIN may_tinh m ON t.ma_may = m.ma_may " +
                     "WHERE t.trang_thai = 'active'";
        
        try (Statement sta = conn.createStatement();
             ResultSet rs = sta.executeQuery(sql)) {
            
            System.out.println("\nKHÁCH HÀNG ĐANG SỬ DỤNG:");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("| %-8s | %-20s | %-12s | %-15s | %-19s |\n", 
                            "Mã KH", "Tên khách", "SĐT", "Máy", "Thời gian sử dụng");
            System.out.println("-----------------------------------------------------------------------------");
            
            while (rs.next()) {
                String maKH = rs.getString("ma_khach");
                String tenKH = rs.getString("ten_khach");
                String sdt = rs.getString("so_dt");
                String tenMay = rs.getString("ten_may");
                String gioBD = rs.getString("gio_bat_dau");
                String gioKT = rs.getString("gio_ket_thuc");
                
                System.out.printf("| %-8s | %-20s | %-12s | %-15s | %s - %s |\n", 
                                maKH, tenKH, sdt, tenMay, gioBD, gioKT);
            }
            System.out.println("-----------------------------------------------------------------------------");
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách khách hàng: " + e.getMessage());
        }
    }
    
    /**
     * Tính tiền và thanh toán cho khách hàng
     */
    public void calculatePayment(String maKhach, String maMay) {
        String sql = "SELECT t.gio_bat_dau, t.gio_ket_thuc, m.gia_gio, " +
                     "COALESCE(SUM(dv.gia_dich_vu), 0) AS tong_dich_vu " +
                     "FROM thoi_gian_su_dung t " +
                     "JOIN may_tinh m ON t.ma_may = m.ma_may " +
                     "LEFT JOIN dich_vu_su_dung dv ON t.ma_su_dung = dv.ma_su_dung " +
                     "WHERE t.ma_khach = ? AND t.ma_may = ? " +
                     "GROUP BY t.gio_bat_dau, t.gio_ket_thuc, m.gia_gio";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, maKhach);
            pstmt.setString(2, maMay);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String gioBD = rs.getString("gio_bat_dau");
                String gioKT = rs.getString("gio_ket_thuc");
                int giaGio = rs.getInt("gia_gio");
                int tongDichVu = rs.getInt("tong_dich_vu");
                
                // Tính thời gian sử dụng (giờ)
                long diffHours = calculateTimeDifference(gioBD, gioKT);
                int tongTienMay = (int) (diffHours * giaGio);
                int tongCong = tongTienMay + tongDichVu;
                
                // Hiển thị hóa đơn
                System.out.println("\nHÓA ĐƠN THANH TOÁN");
                System.out.println("----------------------------------------");
                System.out.println("Máy tính: " + maMay + " - Giá: " + formatCurrency(giaGio) + "/giờ");
                System.out.println("Thời gian: " + gioBD + " đến " + gioKT);
                System.out.println("Thời lượng: " + diffHours + " giờ");
                System.out.println("Tiền máy: " + formatCurrency(tongTienMay));
                System.out.println("Tiền dịch vụ: " + formatCurrency(tongDichVu));
                System.out.println("----------------------------------------");
                System.out.println("TỔNG CỘNG: " + formatCurrency(tongCong));
                System.out.println("----------------------------------------");
                
                // Cập nhật trạng thái thanh toán
                updatePaymentStatus(maKhach, maMay, tongCong);
            } else {
                System.out.println("Không tìm thấy thông tin sử dụng cho khách hàng hoặc máy này.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tính tiền: " + e.getMessage());
        }
    }
    
    /**
     * Cập nhật trạng thái thanh toán vào database
     */
    private void updatePaymentStatus(String maKhach, String maMay, int tongTien) {
        String sql = "UPDATE thoi_gian_su_dung SET trang_thai = 'paid', tong_tien = ? " +
                     "WHERE ma_khach = ? AND ma_may = ? AND trang_thai = 'active'";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tongTien);
            pstmt.setString(2, maKhach);
            pstmt.setString(3, maMay);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật trạng thái thanh toán thành công!");
            } else {
                System.out.println("Không có bản ghi nào được cập nhật.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật thanh toán: " + e.getMessage());
        }
    }
    
    /**
     * Đóng kết nối database
     */
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Đã đóng kết nối database");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
        }
    }
    
    // Các phương thức hỗ trợ
    private long calculateTimeDifference(String startTime, String endTime) {
        // Giả sử định dạng thời gian là 'yyyy-MM-dd HH:mm:ss'
        java.time.LocalDateTime start = java.time.LocalDateTime.parse(startTime, 
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        java.time.LocalDateTime end = java.time.LocalDateTime.parse(endTime, 
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        return java.time.Duration.between(start, end).toHours();
    }
    
    private String formatCurrency(int amount) {
        return String.format("%,d VND", amount);
    }
}