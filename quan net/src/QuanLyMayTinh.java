import java.util.ArrayList;
import java.util.List;

public class QuanLyMayTinh {
    private List<MayTinh> danhSachMayTinh;

    public QuanLyMayTinh() {
        this.danhSachMayTinh = new ArrayList<>();
    }

    public void themMayTinh(MayTinh may) {
        danhSachMayTinh.add(may);
        System.out.println("Đã thêm máy " + may.getMaMay());
    }

    public void suaMayTinh(String maMay, String tenMayMoi, double giaSuDungMoi) {
        for (MayTinh may : danhSachMayTinh) {
            if (may.getMaMay().equals(maMay)) {
                may.capNhatThongTinMay(tenMayMoi, giaSuDungMoi);
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
            System.out.println(may);
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
                case DANG_HOAT_DONG:
                    dangHoatDong++;
                    break;
                case BAO_TRI:
                    baoTri++;
                    break;
                case HONG:
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

