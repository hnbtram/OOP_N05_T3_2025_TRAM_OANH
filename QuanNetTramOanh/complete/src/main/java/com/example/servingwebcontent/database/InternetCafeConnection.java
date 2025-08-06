public class InternetCafeConnection {
    public void checkConnection() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Kết nối quán nét thành công!");
            // Kiểm tra trạng thái các máy
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM may_tinh WHERE trang_thai = 'san_sang'");
            rs.next();
            System.out.println("Số máy sẵn sàng: " + rs.getInt(1));
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối quán nét: " + e.getMessage());
        }
    }
}