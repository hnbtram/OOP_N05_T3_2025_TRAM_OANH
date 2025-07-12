public class ThanhToan {
    private int maThanhToan;
    private int maMay;
    private int maKhachHang;
    private int soGioDaChoi;
    private int tongTien;
    private String thoiGianThanhToan;

    public ThanhToan(int maThanhToan, int maMay, int maKhachHang, int soGioDaChoi, int tongTien, String thoiGianThanhToan) {
        this.maThanhToan = maThanhToan;
        this.maMay = maMay;
        this.maKhachHang = maKhachHang;
        this.soGioDaChoi = soGioDaChoi;
        this.tongTien = tongTien;
        this.thoiGianThanhToan =  thoiGianThanhToan;

    } 
    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;

    }
    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay){
        this.maMay = maMay;

    }

    public int getMaKhachHang(){
        return maKhachHang;
    }

    public void setMaKhacHang(int maKhachHang){
        this.maKhachHang = maKhachHang;

    }

    public int getSoGioDaChoi(){
        return soGioDaChoi;
    }

    public void setSoGioDaChoi(int soGioDaChoi){
        this.soGioDaChoi = soGioDaChoi;
    }

    public int getTongTien(){
        return tongTien;

    }

    public void setTongTien(int tongTien){
        this.tongTien = tongTien;

    }

    public String getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(String thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;

    }

    
}