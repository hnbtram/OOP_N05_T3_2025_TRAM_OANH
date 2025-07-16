import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachHang {
    private String MaKhachHang;
    private String HoTen;
    private String SoDienThoai;
    private List<LichSuNapTien> lichSuNapTien;
    private List<DichVuDaSuDung> dichVuDaSuDung;

    // Constructor
    public KhachHang(String MaKhachHang, String HoTen, String SoDienThoai) {
        this.MaKhachHang = MaKhachHang;
        this.HoTen = HoTen;
        this.SoDienThoai = SoDienThoai;
        this.lichSuNapTien = new ArrayList<>();
        this.dichVuDaSuDung = new ArrayList<>();
    }

    // CRUD operations for KhachHang
    public void capNhatThongTin(String HoTenMoi, String SoDienThoaiMoi) {
        this.HoTen = HoTenMoi;
        this.SoDienThoai = SoDienThoaiMoi;
        System.out.println("Đã cập nhật thông tin khách hàng " + this.MaKhachHang);
    }

    // Lịch sử nạp tiền
    public void themLichSuNapTien(double soTien, Date thoiGian, String phuongThuc) {
        LichSuNapTien ls = new LichSuNapTien(soTien, thoiGian, phuongThuc);
        this.lichSuNapTien.add(ls);
        System.out.println("Đã thêm lịch sử nạp tiền cho khách hàng " + this.MaKhachHang);
    }

    public void xoaLichSuNapTien(int index) {
        if (index >= 0 && index < lichSuNapTien.size()) {
            lichSuNapTien.remove(index);
            System.out.println("Đã xóa lịch sử nạp tiền tại vị trí " + index);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    public void hienThiLichSuNapTien() {
        System.out.println("Lịch sử nạp tiền của khách hàng " + this.HoTen + ":");
        for (int i = 0; i < lichSuNapTien.size(); i++) {
            LichSuNapTien ls = lichSuNapTien.get(i);
            System.out.println((i + 1) + ". Số tiền: " + ls.getSoTien() + 
                              ", Thời gian: " + ls.getThoiGian() + 
                              ", Phương thức: " + ls.getPhuongThuc());
        }
    }

    // Dịch vụ đã sử dụng
    public void themDichVuDaSuDung(String tenDichVu, double gia, Date thoiGianSuDung) {
        DichVuDaSuDung dv = new DichVuDaSuDung(tenDichVu, gia, thoiGianSuDung);
        this.dichVuDaSuDung.add(dv);
        System.out.println("Đã thêm dịch vụ đã sử dụng cho khách hàng " + this.MaKhachHang);
    }

    public void capNhatDichVuDaSuDung(int index, String tenDichVuMoi, double giaMoi, Date thoiGianSuDungMoi) {
        if (index >= 0 && index < dichVuDaSuDung.size()) {
            DichVuDaSuDung dv = dichVuDaSuDung.get(index);
            dv.setTenDichVu(tenDichVuMoi);
            dv.setGia(giaMoi);
            dv.setThoiGianSuDung(thoiGianSuDungMoi);
            System.out.println("Đã cập nhật dịch vụ tại vị trí " + index);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    public void xoaDichVuDaSuDung(int index) {
        if (index >= 0 && index < dichVuDaSuDung.size()) {
            dichVuDaSuDung.remove(index);
            System.out.println("Đã xóa dịch vụ tại vị trí " + index);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    public void hienThiDichVuDaSuDung() {
        System.out.println("Dịch vụ đã sử dụng của khách hàng " + this.HoTen + ":");
        for (int i = 0; i < dichVuDaSuDung.size(); i++) {
            DichVuDaSuDung dv = dichVuDaSuDung.get(i);
            System.out.println((i + 1) + ". Tên dịch vụ: " + dv.getTenDichVu() + 
                              ", Giá: " + dv.getGia() + 
                              ", Thời gian sử dụng: " + dv.getThoiGianSuDung());
        }
    }

    // Getters and Setters
    public String getMaKhachHang() {
        return MaKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.MaKhachHang = maKhachHang;
    }
    public String getHoTen() {
        return HoTen;
    }
    public void setHoTen(String hoTen) {
        this.HoTen = hoTen;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.SoDienThoai = soDienThoai;
    }
    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public List<LichSuNapTien> getLichSuNapTien() {
        return lichSuNapTien;
    }

    public List<DichVuDaSuDung> getDichVuDaSuDung() {
        return dichVuDaSuDung;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "MaKhachHang:'" + MaKhachHang + '\'' +
                ", HoTen:'" + HoTen + '\'' +
                ", SoDienThoai: '" + SoDienThoai + '\'' +
                '}';
    }
}

class LichSuNapTien {
    private double soTien;
    private Date thoiGian;
    private String phuongThuc;

    public LichSuNapTien(double soTien, Date thoiGian, String phuongThuc) {
        this.soTien = soTien;
        this.thoiGian = thoiGian;
        this.phuongThuc = phuongThuc;
    }

    // Getters and Setters
    public double getSoTien() {
        return soTien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setPhuongThuc(String phuongThuc) {
        this.phuongThuc = phuongThuc;
    }
}

class DichVuDaSuDung {
    private String tenDichVu;
    private double gia;
    private Date thoiGianSuDung;

    public DichVuDaSuDung(String tenDichVu, double gia, Date thoiGianSuDung) {
        this.tenDichVu = tenDichVu;
        this.gia = gia;
        this.thoiGianSuDung = thoiGianSuDung;
    }

    // Getters and Setters
    public String getTenDichVu() {
        return tenDichVu;
    }

    public double getGia() {
        return gia;
    }

    public Date getThoiGianSuDung() {
        return thoiGianSuDung;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setThoiGianSuDung(Date thoiGianSuDung) {
        this.thoiGianSuDung = thoiGianSuDung;
    }
}

// Class để quản lý danh sách khách hàng
class QuanLyKhachHang {
    private List<KhachHang> danhSachKhachHang;

    public QuanLyKhachHang() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    // Thêm khách hàng mới
    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
        System.out.println("Đã thêm khách hàng " + kh.getMaKhachHang());
    }

    // Sửa thông tin khách hàng
    public void suaKhachHang(String MaKhachHang, String HoTenMoi, String SoDienThoaiMoi) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equals(MaKhachHang)) {
                kh.capNhatThongTin(HoTenMoi, SoDienThoaiMoi);
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng với mã " + MaKhachHang);
    }

    // Xóa khách hàng
    public void xoaKhachHang(String MaKhachHang) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaKhachHang().equals(MaKhachHang)) {
                danhSachKhachHang.remove(i);
                System.out.println("Đã xóa khách hàng " + MaKhachHang);
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng với mã " + MaKhachHang);
    }

    // Hiển thị tất cả khách hàng
    public void hienThiTatCaKhachHang() {
        System.out.println("Danh sách khách hàng:");
        for (KhachHang kh : danhSachKhachHang) {
            System.out.println(kh);
        }
    }

    // Tìm khách hàng theo mã
    public KhachHang timKhachHangTheoMa(String maKhachHang) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equals(maKhachHang)) {
                return kh;
            }
        }
        return null;
    }
}

