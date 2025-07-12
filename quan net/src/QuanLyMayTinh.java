import java.util.ArrayList;
import java.util.List;
import java.util.Date; 

public class QuanLyMayTinh {
   
    public static void main(String[] args) {
        MayTinh may1 = new MayTinh("MT001");
        may1.capNhatTrangThai(TrangThai.DANG_HOAT_DONG);
        may1.themPhanMem("Windows 10");
        may1.themPhanMem("Microsoft Office");
        
        may1.batDauSuDung();
      
        may1.ketThucSuDung();
        
        System.out.println(may1.thongTinMay());
    }
}

enum TrangThai {
    DANG_HOAT_DONG,
    BAO_TRI,
    HONG
}

class MayTinh {
    private String maMay;
    private TrangThai trangThai;
    private Date batDauSuDung;
    private Date ketThucSuDung;
    private List<String> danhSachPhanMem;
    private double giaTienTheoGio = 10000; // 10,000 VND/giờ

    public MayTinh(String maMay) {
        this.maMay = maMay;
        this.danhSachPhanMem = new ArrayList<>();
        this.trangThai = TrangThai.DANG_HOAT_DONG;
    }

    public void capNhatTrangThai(TrangThai trangThaiMoi) {
        this.trangThai = trangThaiMoi;
    }

    public void themPhanMem(String tenPhanMem) {
        if (!danhSachPhanMem.contains(tenPhanMem)) {
            danhSachPhanMem.add(tenPhanMem);
        }
    }

    public void xoaPhanMem(String tenPhanMem) {
        danhSachPhanMem.remove(tenPhanMem);
    }

    public void batDauSuDung() {
        if (trangThai == TrangThai.DANG_HOAT_DONG) {
            this.batDauSuDung = new Date();
            System.out.println("Bắt đầu sử dụng máy " + maMay);
        } else {
            System.out.println("Máy không sẵn sàng để sử dụng");
        }
    }

    public void ketThucSuDung() {
        this.ketThucSuDung = new Date();
        System.out.println("Kết thúc sử dụng máy " + maMay);
        System.out.println("Thời gian sử dụng: " + tinhThoiGianSuDung() + " phút");
        System.out.println("Chi phí: " + tinhChiPhi() + " VND");
    }

    public long tinhThoiGianSuDung() {
        if (batDauSuDung != null && ketThucSuDung != null) {
            long diff = ketThucSuDung.getTime() - batDauSuDung.getTime();
            return diff / (60 * 1000); // trả về số phút
        }
        return 0;
    }

    public double tinhChiPhi() {
        long phut = tinhThoiGianSuDung();
        double gio = phut / 60.0;
        return gio * giaTienTheoGio;
    }

    public String thongTinMay() {
        return String.format("Máy %s - Trạng thái: %s - Số phần mềm: %d - Giá: %.0f VND/giờ",
                maMay, trangThai, danhSachPhanMem.size(), giaTienTheoGio);
    }


    public String getMaMay() {
        return maMay;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public List<String> getDanhSachPhanMem() {
        return new ArrayList<>(danhSachPhanMem);
    }

}
