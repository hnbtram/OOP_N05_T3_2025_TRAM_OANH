package com.example.servingwebcontent;
import com.example.servingwebcontent.Model.MayTinh;
import com.example.servingwebcontent.Controller.QuanLyMayTinh;


public class QuanLyMayTinhTest {
    
    
    public static void testQuanLyMayTinh() {
        // Khởi tạo đối tượng quản lý
        QuanLyMayTinh qlmt = new QuanLyMayTinh();
        
        // Tạo các máy tính mẫu
        MayTinh mt1 = new MayTinh(01, 150000);
        MayTinh mt2 = new MayTinh(02 , 200000);
        MayTinh mt3 = new MayTinh(03 , 250000);
        MayTinh mtTrungMa = new MayTinh(01, 300000); // Máy tính trùng mã
        
        System.out.println("Bắt đầu kiểm thử QuanLyMayTinh...");
        
        // Test thêm máy tính
       System.out.println("\n1. Test thêm máy tính:");
        qlmt.themMayTinh(mt1);
        qlmt.themMayTinh(mt2);
        qlmt.themMayTinh(mt3);
        System.out.println("- Thêm MT001: Thành công");
        System.out.println("- Thêm MT002: Thành công");
        System.out.println("- Thêm MT003: Thành công");
        System.out.println("- Tổng số máy tính: " + qlmt.getDanhSachMayTinh().size());

        
        // Test thêm máy tính trùng mã
       System.out.println("\n2. Test thêm máy tính trùng mã:");
        qlmt.themMayTinh(mtTrungMa);
        System.out.println("- Thêm MT001 (trùng): Thất bại");
        System.out.println("- Tổng số máy tính : " + qlmt.getDanhSachMayTinh().size());
        
        // Test xóa máy tính
        System.out.println("\n3. Test xóa máy tính:");
        qlmt.xoaMayTinh(02);
        qlmt.xoaMayTinh(99); // Không tồn tại
        System.out.println("- Xóa MT002: Thành công");
        System.out.println("- Xóa MT999 (không tồn tại): Thất bại");
        System.out.println("- Tổng số máy tính sau xóa: " + qlmt.getDanhSachMayTinh().size());
        
        // Test tìm kiếm máy tính
        System.out.println("\n4. Test tìm kiếm máy tính:");
        MayTinh tim1 = qlmt.timMayTinhTheoMa(01);
        MayTinh tim2 = qlmt.timMayTinhTheoMa(99);
        System.out.println("- Tìm MT001: " + (tim1 != null ? "Tìm thấy" : "Không tìm thấy"));
        System.out.println("- Tìm MT999: " + (tim2 != null ? "Tìm thấy" : "Không tìm thấy"));
        
       
        
       
    }
}