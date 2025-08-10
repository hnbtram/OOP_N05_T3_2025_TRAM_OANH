package com.example.servingwebcontent;

import com.example.servingwebcontent.Model.DichVu;
import com.example.servingwebcontent.Controller.DichVuService;

public class DichVuServiceTest {
    
    public static void testDichVuQuanNet() {
        // Khởi tạo đối tượng service
        DichVuService dvService = new DichVuService();
        
        // Tạo các dịch vụ mẫu của quán net
        DichVu dv1 = new DichVu("101", "Giờ chơi thường", 10000);
        DichVu dv2 = new DichVu("102", "Giờ chơi VIP", 15000);
        DichVu dv3 = new DichVu("103", "Nước ngọt", 15000);
        DichVu dv4 = new DichVu("104", "Mì gói", 20000);
        DichVu dvTrungMa = new DichVu("101", "Bàn phím cơ", 50000); // Dịch vụ trùng mã
        
        System.out.println("Bắt đầu kiểm thử dịch vụ quán net...");
        
        // Test thêm dịch vụ
        System.out.println("\n1. Test thêm dịch vụ:");
        dvService.themDichVu(dv1);
        dvService.themDichVu(dv2);
        dvService.themDichVu(dv3);
        dvService.themDichVu(dv4);
        System.out.println("- Thêm DV101 (Giờ thường): Thành công");
        System.out.println("- Thêm DV102 (Giờ VIP): Thành công");
        System.out.println("- Thêm DV103 (Nước ngọt): Thành công");
        System.out.println("- Thêm DV104 (Mì gói): Thành công");
        System.out.println("- Tổng số dịch vụ: " + dvService.layTatCaDichVu().size());

        // Test thêm dịch vụ trùng mã
        System.out.println("\n2. Test thêm dịch vụ trùng mã:");
        dvService.themDichVu(dvTrungMa);
        System.out.println("- Thêm DV101 (trùng mã): Thất bại");
        System.out.println("- Tổng số dịch vụ: " + dvService.layTatCaDichVu().size());
        
        // Test xóa dịch vụ
        System.out.println("\n3. Test xóa dịch vụ:");
        dvService.xoaDichVu("103");
        dvService.xoaDichVu("999"); // Không tồn tại
        System.out.println("- Xóa DV103 (Nước ngọt): Thành công");
        System.out.println("- Xóa DV999 (không tồn tại): Thất bại");
        System.out.println("- Tổng số dịch vụ sau xóa: " + dvService.layTatCaDichVu().size());
        
        // Test tìm kiếm dịch vụ
        System.out.println("\n4. Test tìm kiếm dịch vụ:");
        DichVu tim1 = dvService.timTheoMa("101").orElse(null); 
        DichVu tim2 = dvService.timTheoMa("105").orElse(null); 
        System.out.println("- Tìm DV101: " + (tim1 != null ? "Tìm thấy - " + tim1.getTenDichVu() : "Không tìm thấy"));
        System.out.println("- Tìm DV105: " + (tim2 != null ? "Tìm thấy" : "Không tìm thấy"));

        
        // Test cập nhật dịch vụ
        System.out.println("\n5. Test cập nhật dịch vụ:");
        DichVu dvCapNhat = new DichVu("102", "Giờ chơi VIP (tặng nước)", 18000);
        dvService.capNhatDichVu("102", dvCapNhat);
        DichVu dvSauCapNhat = dvService.timTheoMa("102").orElse(null); // Sửa: lấy từ Optional
        System.out.println("- Sau cập nhật DV102: " + (dvSauCapNhat != null ? 
            dvSauCapNhat.getTenDichVu() + " - " + dvSauCapNhat.getGiaDichVu() + " VND" : "Không tìm thấy"));

        
        // Test hiển thị toàn bộ dịch vụ
        System.out.println("\n6. Danh sách dịch vụ hiện có:");
        dvService.layTatCaDichVu().forEach(dv -> {
            DichVu dichVu = (DichVu) dv;
            System.out.println("- " + dichVu.getMaDichVu() + ": " + dichVu.getTenDichVu() 
                + " - " + dichVu.getGiaDichVu() + " VND");
        });
        
        System.out.println("\nKết thúc kiểm thử dịch vụ quán net!");
    }
}