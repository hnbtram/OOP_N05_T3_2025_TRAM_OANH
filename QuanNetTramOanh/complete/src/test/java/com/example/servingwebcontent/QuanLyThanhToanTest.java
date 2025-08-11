package com.example.servingwebcontent;
import com.example.servingwebcontent.Controller.QuanLyThanhToan;
import com.example.servingwebcontent.Controller.QuanLyKhachHang;
import com.example.servingwebcontent.Controller.QuanLyMayTinh;
import com.example.servingwebcontent.Model.KhachHang;
import com.example.servingwebcontent.Model.MayTinh;
import com.example.servingwebcontent.Model.ThanhToan;
import java.util.List;

public class QuanLyThanhToanTest {
    public static void testQuanLyThanhToan() {
        // Khởi tạo quản lý khách hàng và máy tính
        QuanLyKhachHang qlKhachHang = new QuanLyKhachHang();
        QuanLyMayTinh qlMayTinh = new QuanLyMayTinh();

        // Thêm khách hàng và máy tính mẫu
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn A", "0123456789");
        qlKhachHang.themKhachHang(kh);

        MayTinh may = new MayTinh(1, 15000);
        qlMayTinh.themMayTinh(may);

        // Khách hàng bắt đầu sử dụng máy
        qlMayTinh.batDauSuDungMay(1, "KH001");

        // Khởi tạo quản lý thanh toán
        QuanLyThanhToan qlThanhToan = new QuanLyThanhToan(qlKhachHang, qlMayTinh);

        // Thực hiện thanh toán
        boolean thanhToanThanhCong = qlThanhToan.thanhToan("KH001", 1);

        System.out.println("Kết quả thanh toán: " + (thanhToanThanhCong ? "Thành công" : "Thất bại"));

        // Hiển thị danh sách hóa đơn
        List<ThanhToan> danhSachHoaDon = qlThanhToan.getDanhSachHoaDon();
        System.out.println("Danh sách hóa đơn:");
        for (ThanhToan hd : danhSachHoaDon) {
            System.out.println("- Mã hóa đơn: " + hd.getMaHoaDon() +
                               ", Mã KH: " + hd.getMaKhachHang() +
                               ", ID máy: " + hd.getIdMayTinh() +
                               ", Thành tiền: " + hd.getThanhTien());
        }
    }
}