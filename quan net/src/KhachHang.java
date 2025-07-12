import java.util.ArrayList;
import java.util.List;

public class KhachHang {
    
    private String maKhachHang;
    private String hoTen;
    private String soDienThoai;

    
    private List<Double> lichSuNapTien;
    private List<String> cacDichVuDaSuDung;

    
    public KhachHang(String maKhachHang, String hoTen, String soDienThoai) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.lichSuNapTien = new ArrayList<>();
        this.cacDichVuDaSuDung = new ArrayList<>();
    }

    
    public void setHoTen(String newHoTen) {
        this.hoTen = newHoTen;
        System.out.println("Đã cập nhật tên khách hàng " + this.maKhachHang + " thành: " + newHoTen);
    }

    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

   
    public void xemLichSuNapTien() {
        System.out.println("Lịch sử nạp tiền của " + hoTen + ": " + lichSuNapTien);
    }

    
    public void napTien(double amount) {
        if (amount > 0) {
            lichSuNapTien.add(amount);
            System.out.println(hoTen + " đã nạp thành công: " + amount + " VND");
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }

    
    public void themDichVuDaSuDung(String service) {
        cacDichVuDaSuDung.add(service);
        System.out.println("Dịch vụ '" + service + "' đã được thêm vào lịch sử của " + hoTen);
    }

    public void xemCacDichVuDaSuDung() {
        System.out.println("Các dịch vụ " + hoTen + " đã sử dụng: " + cacDichVuDaSuDung);
    }

    
    public static void main(String[] args) {
        
        KhachHang khach1 = new KhachHang("KH001", "Nguyen Van A", "0912345678");

        
        System.out.println("--- Thông tin Khách hàng 1 ---");
        System.out.println("Mã: " + khach1.getMaKhachHang());
        System.out.println("Tên: " + khach1.getHoTen());
        System.out.println("SĐT: " + khach1.getSoDienThoai());
        khach1.xemLichSuNapTien();
        khach1.xemCacDichVuDaSuDung();

       
        khach1.napTien(50000.0);
        khach1.napTien(100000.0);

       
        khach1.themDichVuDaSuDung("Game Lien Minh");
        khach1.themDichVuDaSuDung("Internet 1 ngay");
        khach1.themDichVuDaSuDung("Cafe sua da");

        
        khach1.setHoTen("Nguyen Van An");

       
        System.out.println("\n--- Thông tin Khách hàng 1 (sau khi cập nhật) ---");
        System.out.println("Mã: " + khach1.getMaKhachHang());
        System.out.println("Tên: " + khach1.getHoTen());
        System.out.println("SĐT: " + khach1.getSoDienThoai());
        khach1.xemLichSuNapTien();
        khach1.xemCacDichVuDaSuDung();

        
    }
}