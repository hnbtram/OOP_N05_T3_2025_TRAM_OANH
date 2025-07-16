import java.text.SimpleDateFormat;
import java.util.Date;

public class testQuanLyKhachHang {
    public static void main(String[] args) {
        // Tạo đối tượng quản lý khách hàng
        QuanLyKhachHang quanLyKH = new QuanLyKhachHang();
        
        // Định dạng ngày tháng
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date(); 
        System.out.println("Thời gian: " + dateFormat.format(now));
        try {
            // 1. Thêm khách hàng mới
            System.out.println("=== THÊM KHÁCH HÀNG MỚI ===");
            KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A", "0912345678");
            KhachHang kh2 = new KhachHang("KH002", "Trần Thị B", "0987654321");
            quanLyKH.themKhachHang(kh1);
            quanLyKH.themKhachHang(kh2);
            
            // 2. Hiển thị tất cả khách hàng
            System.out.println("\n=== DANH SÁCH KHÁCH HÀNG ===");
            quanLyKH.hienThiTatCaKhachHang();
            
            // 3. Thêm lịch sử nạp tiền cho khách hàng
            System.out.println("\n=== THÊM LỊCH SỬ NẠP TIỀN ===");
           
            kh1.themLichSuNapTien(500000, now, "Chuyển khoản");
            kh1.themLichSuNapTien(200000, new Date(now.getTime() + 1000000), "Tiền mặt");
            kh2.themLichSuNapTien(1000000, now, "Thẻ tín dụng");
            
            // Hiển thị lịch sử nạp tiền
            System.out.println("Thời gian nap tiền: " + dateFormat.format(now));
            System.out.println("\nLịch sử nạp tiền của KH001:");
            kh1.hienThiLichSuNapTien();
            
            // 4. Thêm dịch vụ đã sử dụng
            System.out.println("\n=== THÊM DỊCH VỤ ĐÃ SỬ DỤNG ===");
            kh1.themDichVuDaSuDung("Mì tôm hai trứng", 80000, now);
            kh1.themDichVuDaSuDung("Sting", 15000, new Date(now.getTime() + 2000000));
            kh2.themDichVuDaSuDung("Cà Phê", 250000, now);
            
            // Hiển thị dịch vụ đã sử dụng
            System.out.println("\nDịch vụ đã sử dụng của KH001:");
            kh1.hienThiDichVuDaSuDung();
            
            // 5. Cập nhật thông tin khách hàng
            System.out.println("\n=== CẬP NHẬT THÔNG TIN KHÁCH HÀNG ===");
            quanLyKH.suaKhachHang("KH001", "Nguyễn Văn A Updated", "0912349999");
            quanLyKH.hienThiTatCaKhachHang();
            
            // 6. Xóa một dịch vụ đã sử dụng
            System.out.println("\n=== XÓA DỊCH VỤ ĐÃ SỬ DỤNG ===");
            kh1.xoaDichVuDaSuDung(0); // Xóa dịch vụ "Cà phê"
            kh1.hienThiDichVuDaSuDung();
            
            // 7. Xóa một lịch sử nạp tiền
            System.out.println("\n=== XÓA LỊCH SỬ NẠP TIỀN ===");
            kh1.xoaLichSuNapTien(1); // Xóa lần nạp thứ 2
            kh1.hienThiLichSuNapTien();
            
            // 8. Tìm kiếm khách hàng
            System.out.println("\n=== TÌM KIẾM KHÁCH HÀNG ===");
            KhachHang khTimThay = quanLyKH.timKhachHangTheoMa("KH002");
            if (khTimThay != null) {
                System.out.println("Tìm thấy khách hàng: " + khTimThay);
            } else {
                System.out.println("Không tìm thấy khách hàng");
            }
            
            // 9. Xóa khách hàng
            System.out.println("\n=== XÓA KHÁCH HÀNG ===");
            quanLyKH.xoaKhachHang("KH002");
            quanLyKH.hienThiTatCaKhachHang();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}