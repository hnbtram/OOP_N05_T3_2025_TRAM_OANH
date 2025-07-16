import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class QuanLyMayTinh {
    private List<MayTinh> danhSachMayTinh;

    public QuanLyMayTinh() {
        this.danhSachMayTinh = new ArrayList<>();
    }

    // Getter cho danh sách máy tính
    public List<MayTinh> getDanhSachMayTinh() {
        return danhSachMayTinh;
    }

    // Setter cho danh sách máy tính
    public void setDanhSachMayTinh(List<MayTinh> danhSachMayTinh) {
        this.danhSachMayTinh = danhSachMayTinh;
    }

    public void themMayTinh(MayTinh may) {
        danhSachMayTinh.add(may);
        System.out.println("Đã thêm máy " + may.getMaMay());
    }

    public void suaMayTinh(String maMay, String tenMayMoi, double giaSuDungMoi) {
        for (MayTinh may : danhSachMayTinh) {
            if (may.getMaMay().equals(maMay)) {
                may.setTenMay(tenMayMoi);
                may.setGiaTheoGio(giaSuDungMoi);
                System.out.println("Đã cập nhật thông tin máy " + maMay);
                return;
            }
        }
        System.out.println("Không tìm thấy máy với mã " + maMay);
    }

    public void xoaMayTinh(String maMay) {
        for (int i = 0; i < danhSachMayTinh.size(); i++) {
            if (danhSachMayTinh.get(i).getMaMay().equals(maMay)) {
                danhSachMayTinh.remove(i);
                System.out.println("Đã xóa máy " + maMay);
                return;
            }
        }
        System.out.println("Không tìm thấy máy với mã " + maMay);
    }

    public void hienThiTatCaMayTinh() {
        System.out.println("Danh sách máy tính:");
        for (MayTinh may : danhSachMayTinh) {
            System.out.println("Mã máy: " + may.getMaMay() + 
                             ", Tên máy: " + may.getTenMay() + 
                             ", Cấu hình: " + may.getCauHinh() + 
                             ", Trạng thái: " + may.getTrangThai());
        }
    }

    public MayTinh timMayTinhTheoMa(String maMay) {
        for (MayTinh may : danhSachMayTinh) {
            if (may.getMaMay().equals(maMay)) {
                return may;
            }
        }
        return null;
    }

    public void thongKeTheoTrangThai() {
        int dangHoatDong = 0;
        int baoTri = 0;
        int hong = 0;

        for (MayTinh may : danhSachMayTinh) {
            switch (may.getTrangThai()) {
                case "DANG_HOAT_DONG":
                    dangHoatDong++;
                    break;
                case "BAO_TRI":
                    baoTri++;
                    break;
                case "HONG":
                    hong++;
                    break;
            }
        }

        System.out.println("Thống kê trạng thái máy tính:");
        System.out.println("- Đang hoạt động: " + dangHoatDong);
        System.out.println("- Bảo trì: " + baoTri);
        System.out.println("- Hỏng: " + hong);
    }
}

class MayTinh {
    private String maMay;
    private String tenMay;
    private String cauHinh;
    private String trangThai;
    private double giaTheoGio;
    private List<String> danhSachPhanMem;
    private List<LocalDateTime> thoiGianBatDau;
    private List<LocalDateTime> thoiGianKetThuc;
    private List<Double> chiPhiSuDung;

    public MayTinh() {
        this.danhSachPhanMem = new ArrayList<>();
        this.thoiGianBatDau = new ArrayList<>();
        this.thoiGianKetThuc = new ArrayList<>();
        this.chiPhiSuDung = new ArrayList<>();
    }

    // Getter và Setter
    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getGiaTheoGio() {
        return giaTheoGio;
    }

    public void setGiaTheoGio(double giaTheoGio) {
        this.giaTheoGio = giaTheoGio;
    }

    public List<String> getDanhSachPhanMem() {
        return danhSachPhanMem;
    }

    public void setDanhSachPhanMem(List<String> danhSachPhanMem) {
        this.danhSachPhanMem = danhSachPhanMem;
    }

    // Các phương thức khác
    public void themPhanMem(String phanMem) {
        this.danhSachPhanMem.add(phanMem);
    }

    public void xoaPhanMem(String phanMem) {
        this.danhSachPhanMem.remove(phanMem);
    }
}
    