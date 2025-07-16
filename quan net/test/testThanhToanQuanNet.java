
import java.util.Date;

public class testThanhToanQuanNet {
    public static void main(String[] args) {
        // Tạo khách hàng
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A", "0912345678");
        
        // Tạo máy tính
        MayTinh may1 = new MayTinh("MT001", "Máy VIP", "i7, 16GB RAM, RTX 3080", 25000);
        
        
        // Tạo quản lý thanh toán
        QuanLyThanhToanQuanNet qltt = new QuanLyThanhToanQuanNet();
        
        // Tạo thanh toán mới
        ThanhToanQuanNet tt1 = new ThanhToanQuanNet("HD001", kh1, may1);
       
        
        // Thêm dịch vụ sử dụng
        DichVuSuDung dv1 = new DichVuSuDung("Nước ngọt", 15000, 2);
        DichVuSuDung dv2 = new DichVuSuDung("Mì gói", 20000, 1);
        
        tt1.themDichVu(dv1);
        tt1.themDichVu(dv2);
        
        // Thêm vào quản lý thanh toán
        qltt.themHoaDon(tt1);
        
        // Giả sử sau 3 giờ sử dụng
        Date endTime = new Date(tt1.getThoiGianBatDau().getTime() + (3 * 60 * 60 * 1000));
        tt1.setThoiGianKetThuc(endTime);
        
        // Áp dụng khuyến mãi 10% cho khách VIP
        tt1.apDungKhuyenMai(10);
        
        // In hóa đơn trước khi thanh toán
        System.out.println("\nHóa đơn trước khi thanh toán:");
        tt1.inHoaDon();
        
        // Xác nhận thanh toán
        tt1.xacNhanThanhToan();
        
        // Hiển thị tất cả hóa đơn
        qltt.hienThiTatCaHoaDon();
    }
}

