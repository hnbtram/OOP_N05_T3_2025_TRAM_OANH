 import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThanhToanQuanNet {
    private String maHoaDon;
    private KhachHang khachHang;
    private MayTinh mayTinh;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private List<DichVuSuDung> dichVuSuDung;
    private double khuyenMai; // Phần trăm khuyến mãi (0-100)
    private boolean daThanhToan;

    // Constructor
    public ThanhToanQuanNet(String maHoaDon, KhachHang khachHang, MayTinh mayTinh) {
        this.maHoaDon = maHoaDon;
        this.khachHang = khachHang;
        this.mayTinh = mayTinh;
        this.thoiGianBatDau = new Date();
        this.dichVuSuDung = new ArrayList<>();
        this.khuyenMai = 0;
        this.daThanhToan = false;
    }

    // CRUD operations for DichVuSuDung
    public void themDichVu(DichVuSuDung dichVu) {
        this.dichVuSuDung.add(dichVu);
        System.out.println("Đã thêm dịch vụ: " + dichVu.getTenDichVu());
    }

    public void suaDichVu(int index, DichVuSuDung dichVuMoi) {
        if (index >= 0 && index < dichVuSuDung.size()) {
            dichVuSuDung.set(index, dichVuMoi);
            System.out.println("Đã cập nhật dịch vụ tại vị trí " + index);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    public void xoaDichVu(int index) {
        if (index >= 0 && index < dichVuSuDung.size()) {
            DichVuSuDung dv = dichVuSuDung.remove(index);
            System.out.println("Đã xóa dịch vụ: " + dv.getTenDichVu());
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    // Tính tiền sử dụng máy (theo giờ)
    public double tinhTienSuDungMay() {
        if (thoiGianKetThuc == null) {
            thoiGianKetThuc = new Date();
        }
        
        long thoiGianSuDung = thoiGianKetThuc.getTime() - thoiGianBatDau.getTime();
        double soGio = thoiGianSuDung / (1000.0 * 60 * 60); // Chuyển từ milliseconds sang giờ
        
        // Tính theo cấu hình máy
        return soGio * mayTinh.getGiaTienTheoGio();
    }

    // Tính tiền các dịch vụ đi kèm
    public double tinhTienDichVu() {
        double tongTien = 0;
        for (DichVuSuDung dv : dichVuSuDung) {
            tongTien += dv.getGia() * dv.getSoLuong();
        }
        return tongTien;
    }

    // Áp dụng khuyến mãi
    public void apDungKhuyenMai(double phanTramKhuyenMai) {
        if (phanTramKhuyenMai >= 0 && phanTramKhuyenMai <= 100) {
            this.khuyenMai = phanTramKhuyenMai;
            System.out.println("Đã áp dụng khuyến mãi " + phanTramKhuyenMai + "%");
        } else {
            System.out.println("Phần trăm khuyến mãi không hợp lệ (0-100)");
        }
    }

    // Tính tổng tiền sau khuyến mãi
    public double tinhTongTien() {
        double tienSuDungMay = tinhTienSuDungMay();
        double tienDichVu = tinhTienDichVu();
        double tongTien = tienSuDungMay + tienDichVu;
        return tongTien * (1 - khuyenMai / 100);
    }

    // Xác nhận thanh toán
    public void xacNhanThanhToan() {
        this.daThanhToan = true;
        this.thoiGianKetThuc = new Date();
        
        System.out.println("Đã xác nhận thanh toán hóa đơn " + maHoaDon);
    }

    // In hóa đơn
    public void inHoaDon() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        System.out.println("\n============ HÓA ĐƠN QUÁN NET ============");
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Khách hàng: " + khachHang.getHoTen());
        System.out.println("SĐT: " + khachHang.getSoDienThoai());
        System.out.println("Máy tính: " + mayTinh.getTenMay() + " (" + mayTinh.getCauHinh() + ")");
        System.out.println("Thời gian bắt đầu: " + sdf.format(thoiGianBatDau));
        System.out.println("Thời gian kết thúc: " + sdf.format(thoiGianKetThuc));
        
        System.out.println("\nChi tiết dịch vụ:");
        System.out.printf("%-20s %-10s %-15s %-15s\n", "Tên dịch vụ", "Số lượng", "Đơn giá", "Thành tiền");
        for (DichVuSuDung dv : dichVuSuDung) {
            System.out.printf("%-20s %-10d %-15.2f %-15.2f\n", 
                           dv.getTenDichVu(), dv.getSoLuong(), dv.getGia(), dv.getGia() * dv.getSoLuong());
        }
        
        System.out.println("\nTổng cộng:");
        System.out.printf("Tiền sử dụng máy (%.2f giờ): %.2f\n", 
                         (thoiGianKetThuc.getTime() - thoiGianBatDau.getTime()) / (1000.0 * 60 * 60),
                         tinhTienSuDungMay());
        System.out.printf("Tiền dịch vụ: %.2f\n", tinhTienDichVu());
        System.out.printf("Khuyến mãi: %.2f%%\n", khuyenMai);
        System.out.printf("TỔNG TIỀN: %.2f\n", tinhTongTien());
        System.out.println("Trạng thái: " + (daThanhToan ? "Đã thanh toán" : "Chưa thanh toán"));
        System.out.println("========================================\n");
    }

    // Getters and Setters
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public MayTinh getMayTinh() {
        return mayTinh;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public List<DichVuSuDung> getDichVuSuDung() {
        return dichVuSuDung;
    }

    public double getKhuyenMai() {
        return khuyenMai;
    }

    public boolean isDaThanhToan() {
        return daThanhToan;
    }
}

class MayTinh {
    private String maMay;
    private String tenMay;
    private String cauHinh;
    private double giaTienTheoGio;
    

    public MayTinh(String maMay, String tenMay, String cauHinh, double giaTienTheoGio) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.cauHinh = cauHinh;
        this.giaTienTheoGio = giaTienTheoGio;
       
    }

    // Getters and Setters
    public String getMaMay() {
        return maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public double getGiaTienTheoGio() {
        return giaTienTheoGio;
    }

   
}

class DichVuSuDung {
    private String tenDichVu;
    private double gia;
    private int soLuong;

    public DichVuSuDung(String tenDichVu, double gia, int soLuong) {
        this.tenDichVu = tenDichVu;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    // Getters and Setters
    public String getTenDichVu() {
        return tenDichVu;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

class QuanLyThanhToanQuanNet {
    private List<ThanhToanQuanNet> danhSachHoaDon;

    public QuanLyThanhToanQuanNet() {
        this.danhSachHoaDon = new ArrayList<>();
    }

    // Thêm hóa đơn mới
    public void themHoaDon(ThanhToanQuanNet hoaDon) {
        danhSachHoaDon.add(hoaDon);
        System.out.println("Đã thêm hóa đơn " + hoaDon.getMaHoaDon());
    }

    // Xóa hóa đơn
    public void xoaHoaDon(String maHoaDon) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getMaHoaDon().equals(maHoaDon)) {
                danhSachHoaDon.remove(i);
                System.out.println("Đã xóa hóa đơn " + maHoaDon);
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn " + maHoaDon);
    }

    // Cập nhật hóa đơn
    public void capNhatHoaDon(String maHoaDon, ThanhToanQuanNet hoaDonMoi) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getMaHoaDon().equals(maHoaDon)) {
                danhSachHoaDon.set(i, hoaDonMoi);
                System.out.println("Đã cập nhật hóa đơn " + maHoaDon);
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn " + maHoaDon);
    }

    // Tìm hóa đơn theo mã
    public ThanhToanQuanNet timHoaDonTheoMa(String maHoaDon) {
        for (ThanhToanQuanNet hd : danhSachHoaDon) {
            if (hd.getMaHoaDon().equals(maHoaDon)) {
                return hd;
            }
        }
        return null;
    }

    // Hiển thị tất cả hóa đơn
    public void hienThiTatCaHoaDon() {
        System.out.println("\nDANH SÁCH HÓA ĐƠN");
        System.out.printf("%-10s %-15s %-10s %-15s %-10s\n", 
                         "Mã HD", "Khách hàng", "Máy", "Tổng tiền", "Trạng thái");
        for (ThanhToanQuanNet hd : danhSachHoaDon) {
            System.out.printf("%-10s %-15s %-10s %-15.2f %-10s\n", 
                            hd.getMaHoaDon(), 
                            hd.getKhachHang().getHoTen(), 
                            hd.getMayTinh().getMaMay(),
                            hd.tinhTongTien(),
                            hd.isDaThanhToan() ? "Đã TT" : "Chưa TT");
        }
    }
}

