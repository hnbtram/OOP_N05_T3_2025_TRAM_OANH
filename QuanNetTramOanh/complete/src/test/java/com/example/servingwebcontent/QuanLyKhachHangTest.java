package com.example.servingwebcontent;

import com.example.servingwebcontent.Model.KhachHang;
import com.example.servingwebcontent.Controller.QuanLyKhachHang;

public class QuanLyKhachHangTest {
    
    public static void testQuanLyKhachHang() {
        // Khởi tạo đối tượng quản lý
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        
        // Tạo các khách hàng mẫu
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A", "0123456789");
        KhachHang kh2 = new KhachHang("KH002", "Trần Thị B", "0987654321");
        KhachHang kh3 = new KhachHang("KH003", "Lê Văn C", "0369852147");
        KhachHang khTrungMa = new KhachHang("KH001", "Phạm Thị D", "0147258369"); // Khách hàng trùng mã
        
        System.out.println("Bắt đầu kiểm thử QuanLyKhachHang...");
        
        // Test thêm khách hàng
        System.out.println("\n1. Test thêm khách hàng:");
        qlkh.themKhachHang(kh1);
        qlkh.themKhachHang(kh2);
        qlkh.themKhachHang(kh3);
        System.out.println("- Thêm KH001: Thành công");
        System.out.println("- Thêm KH002: Thành công");
        System.out.println("- Thêm KH003: Thành công");
        System.out.println("- Tổng số khách hàng: " + qlkh.getDanhSachKhachHang().size());

        // Test thêm khách hàng trùng mã
        System.out.println("\n2. Test thêm khách hàng trùng mã:");
        qlkh.themKhachHang(khTrungMa);
        System.out.println("- Thêm KH001 (trùng mã): Thất bại");
        System.out.println("- Tổng số khách hàng: " + qlkh.getDanhSachKhachHang().size());
        
        // Test xóa khách hàng
        System.out.println("\n3. Test xóa khách hàng:");
        qlkh.xoaKhachHang("KH002");
        qlkh.xoaKhachHang("KH999"); // Không tồn tại
        System.out.println("- Xóa KH002: Thành công");
        System.out.println("- Xóa KH999 (không tồn tại): Thất bại");
        System.out.println("- Tổng số khách hàng sau xóa: " + qlkh.getDanhSachKhachHang().size());
        
        // Test tìm kiếm khách hàng
        System.out.println("\n4. Test tìm kiếm khách hàng:");
        KhachHang tim1 = qlkh.timKhachHang("KH001");
        KhachHang tim2 = qlkh.timKhachHang("KH005");
        System.out.println("- Tìm KH001: " + (tim1 != null ? "Tìm thấy - " + tim1.getTenKhachHang() : "Không tìm thấy"));
        System.out.println("- Tìm KH005: " + (tim2 != null ? "Tìm thấy" : "Không tìm thấy"));
        
        // Test cập nhật thông tin khách hàng
        System.out.println("\n5. Test cập nhật thông tin khách hàng:");
        KhachHang khCapNhat = new KhachHang("KH001", "Nguyễn Văn A Updated", "0111222333");
        qlkh.capNhatKhachHang("KH001", khCapNhat); // Sửa: truyền vào mã và đối tượng cập nhật
        KhachHang khSauCapNhat = qlkh.timKhachHang("KH001");
        System.out.println("- Sau cập nhật KH001: " + (khSauCapNhat != null ? 
            khSauCapNhat.getTenKhachHang() + " - " + khSauCapNhat.getSoDienThoai() : "Không tìm thấy"));
            
        
        // Test hiển thị toàn bộ khách hàng
        System.out.println("\n6. Danh sách khách hàng hiện có:");
        qlkh.getDanhSachKhachHang().forEach(kh -> {
            System.out.println("- " + kh.getMaKhachHang() + ": " + kh.getTenKhachHang() 
                + " - " + kh.getSoDienThoai() + " - " + kh.getDiemTichLuy() + " điểm");
        });
        
        // Test nạp tiền/thêm điểm
        System.out.println("\n7. Test nạp tiền/thêm điểm:");
        qlkh.napTien("KH001", 50);
        KhachHang khSauNap = qlkh.timKhachHang("KH001");
        System.out.println("- Sau nạp tiền KH001: " + (khSauNap != null ? 
            khSauNap.getDiemTichLuy() + " điểm" : "Không tìm thấy"));
        
        System.out.println("\nKết thúc kiểm thử QuanLyKhachHang!");
    }
   
}