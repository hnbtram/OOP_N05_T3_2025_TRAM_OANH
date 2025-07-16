import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MayTinh {
    private String maMay;
    private String tenMay;
    private TrangThaiMay trangThai;
    private Date thoiGianBatDauSuDung;
    private Date thoiGianKetThucSuDung;
    private List<String> danhSachPhanMem;
    private double giaSuDungTheoGio;

    // Enum cho trạng thái máy
    public enum TrangThaiMay {
        DANG_HOAT_DONG,
        BAO_TRI,
        HONG
    }

    // Constructor
    public MayTinh(String maMay, String tenMay, double giaSuDungTheoGio) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.giaSuDungTheoGio = giaSuDungTheoGio;
        this.trangThai = TrangThaiMay.DANG_HOAT_DONG;
        this.danhSachPhanMem = new ArrayList<>();
    }

    // CRUD operations
    public void capNhatThongTinMay(String tenMayMoi, double giaSuDungMoi) {
        this.tenMay = tenMayMoi;
        this.giaSuDungTheoGio = giaSuDungMoi;
        System.out.println("Đã cập nhật thông tin máy " + this.maMay);
    }

    public void thayDoiTrangThai(TrangThaiMay trangThaiMoi) {
        this.trangThai = trangThaiMoi;
        System.out.println("Đã thay đổi trạng thái máy " + this.maMay + " thành " + trangThaiMoi);
    }

    // Quản lý thời gian sử dụng
    public void batDauSuDung() {
        if (this.trangThai != TrangThaiMay.DANG_HOAT_DONG) {
            System.out.println("Không thể bắt đầu sử dụng máy " + this.maMay + " do máy đang ở trạng thái " + this.trangThai);
            return;
        }
        this.thoiGianBatDauSuDung = new Date();
        System.out.println("Đã bắt đầu sử dụng máy " + this.maMay);
    }

    public void ketThucSuDung() {
        if (this.thoiGianBatDauSuDung == null) {
            System.out.println("Máy " + this.maMay + " chưa được bắt đầu sử dụng");
            return;
        }
        this.thoiGianKetThucSuDung = new Date();
        System.out.println("Đã kết thúc sử dụng máy " + this.maMay);
    }

    // Tính toán chi phí
    public double tinhChiPhi() {
        if (thoiGianBatDauSuDung == null || thoiGianKetThucSuDung == null) {
            System.out.println("Không thể tính chi phí do thiếu thông tin thời gian");
            return 0;
        }
        long thoiGianSuDung = thoiGianKetThucSuDung.getTime() - thoiGianBatDauSuDung.getTime();
        double soGioSuDung = thoiGianSuDung / (1000.0 * 60 * 60); // Chuyển từ mili giây sang giờ
        return soGioSuDung * giaSuDungTheoGio;
    }

    // Quản lý phần mềm/game
    public void themPhanMem(String tenPhanMem) {
        if (!danhSachPhanMem.contains(tenPhanMem)) {
            danhSachPhanMem.add(tenPhanMem);
            System.out.println("Đã thêm phần mềm " + tenPhanMem + " vào máy " + this.maMay);
        } else {
            System.out.println("Phần mềm " + tenPhanMem + " đã có trên máy " + this.maMay);
        }
    }

    public void xoaPhanMem(String tenPhanMem) {
        if (danhSachPhanMem.remove(tenPhanMem)) {
            System.out.println("Đã xóa phần mềm " + tenPhanMem + " khỏi máy " + this.maMay);
        } else {
            System.out.println("Không tìm thấy phần mềm " + tenPhanMem + " trên máy " + this.maMay);
        }
    }

    public void hienThiDanhSachPhanMem() {
        System.out.println("Danh sách phần mềm trên máy " + this.tenMay + ":");
        for (String phanMem : danhSachPhanMem) {
            System.out.println("- " + phanMem);
        }
    }

    // Getters and Setters
    public String getMaMay() {
        return maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public TrangThaiMay getTrangThai() {
        return trangThai;
    }

    public Date getThoiGianBatDauSuDung() {
        return thoiGianBatDauSuDung;
    }

    public Date getThoiGianKetThucSuDung() {
        return thoiGianKetThucSuDung;
    }

    public List<String> getDanhSachPhanMem() {
        return danhSachPhanMem;
    }

    public double getGiaSuDungTheoGio() {
        return giaSuDungTheoGio;
    }

    @Override
    public String toString() {
        return "MayTinh{" +
                "maMay='" + maMay + '\'' +
                ", tenMay='" + tenMay + '\'' +
                ", trangThai=" + trangThai +
                ", giaSuDungTheoGio=" + giaSuDungTheoGio +
                '}';
    }
}

