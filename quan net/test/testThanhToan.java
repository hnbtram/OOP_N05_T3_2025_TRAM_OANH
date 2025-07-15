public class testThanhToan {
    public static void test() {
        ThanhToan thanhToan = new ThanhToan(1, 101, 202, 3, 15000, "2025-01-01 10:00:00");
        System.out.println("Mã Thanh Toán: " + thanhToan.getMaThanhToan());
        System.out.println("Mã Máy: " + thanhToan.getMaMay());
        System.out.println("Mã Khách Hàng: " + thanhToan.getMaKhachHang());
        System.out.println("Số Giờ Đã Chơi: " + thanhToan.getSoGioDaChoi());
        System.out.println("Tổng Tiền: " + thanhToan.getTongTien());
        System.out.println("Thời Gian Thanh Toán: " + thanhToan.getThoiGianThanhToan());
    }

    public static void main(String[] args) {
        test();
    }
}