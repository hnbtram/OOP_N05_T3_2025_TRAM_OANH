

import QuanNet.MayTinh;
import QuanNet.QuanLyMayTinh;

public class TestQuanLyMayTinh {
    public static void test() {
        // 1. Khởi tạo một đối tượng QuanLyMayTinh
        System.out.println("--- Khởi tạo Quản lý Máy tính ---");
        QuanLyMayTinh quanLy = new QuanLyMayTinh();

        // 2. Thêm một số máy tính
        System.out.println("\n--- Thêm Máy tính ---");
        MayTinh may1 = new MayTinh(101, 25000000);
        MayTinh may2 = new MayTinh(102, 35000000);
        quanLy.themMayTinh(may1);
        quanLy.themMayTinh(may2);

        // 3. Hiển thị danh sách máy tính hiện có
        System.out.println("\n--- Danh sách Máy tính sau khi thêm ---");
        for (MayTinh may : quanLy.getDanhSachMayTinh()) {
            System.out.println(may);
        }

        // 4. Cập nhật giá của một máy tính
        System.out.println("\n--- Cập nhật giá Máy tính 101 ---");
        quanLy.capNhatGiaMayTinh(101, 26000000);
        System.out.println("Giá mới của Máy tính 101: " + quanLy.timMayTinh(101).getGiaTienTheoGio());

        // 5. Bắt đầu và kết thúc sử dụng một máy tính
        System.out.println("\n--- Kiểm tra sử dụng Máy tính 102 ---");
        boolean batDau = quanLy.batDauSuDungMay(102, "KH_VIP_007");
        System.out.println("Bắt đầu sử dụng Máy tính 102 thành công: " + batDau);
        System.out.println(quanLy.timMayTinh(102)); // Kiểm tra trạng thái
        double ketThuc = quanLy.ketThucSuDungMay(102);
       

        
        System.out.println("Kết thúc sử dụng Máy tính 102 thành công: " + ketThuc);
        System.out.println(quanLy.timMayTinh(102)); // Kiểm tra trạng thái

        // 6. Xóa một máy tính
        System.out.println("\n--- Xóa Máy tính 101 ---");
        boolean xoa = quanLy.xoaMayTinh(101);
        System.out.println("Xóa Máy tính 101 thành công: " + xoa);

        // 7. Hiển thị lại danh sách sau khi xóa
        System.out.println("\n--- Danh sách Máy tính sau khi xóa ---");
        if (quanLy.getDanhSachMayTinh().isEmpty()) {
            System.out.println("Danh sách máy tính trống.");
        } else {
            for (MayTinh may : quanLy.getDanhSachMayTinh()) {
                System.out.println(may);
            }
        }
    }
}