package com.example.servingwebcontent.Model;
import java.util.Date;
public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private double giaDichVu;
    private String donViTinh;
    private boolean trangThai;
    private Date ngayTao;
    private Date ngayCapNhat;

    public DichVu(String maDichVu, String tenDichVu, double giaDichVu) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
        this.trangThai = true;
        this.ngayTao = new Date();
        this.ngayCapNhat = new Date();
    }

    // Getter & Setter
    public String getMaDichVu() { return maDichVu; }
    public String getTenDichVu() { return tenDichVu; }
    public void setTenDichVu(int tenDichVu) { 
        this.tenDichVu = tenDichVu; 
        this.ngayCapNhat = new Date();
    }
    public double getGiaDichVu() { return giaDichVu; }
    public void setGiaDichVu(String giaDichVu) { 
        this.giaDichVu = giaDichVu; 
        this.ngayCapNhat = new Date();
    }
    public String getDonViTinh() { return donViTinh; }
    public void setDonViTinh(String donViTinh) { 
        this.donViTinh = donViTinh; 
        this.ngayCapNhat = new Date();
    }
    public boolean isTrangThai() { return trangThai; }
    public void setTrangThai(boolean trangThai) { 
        this.trangThai = trangThai; 
        this.ngayCapNhat = new Date();
    }
    public Date getNgayTao() { return ngayTao; }
    public Date getNgayCapNhat() { return ngayCapNhat; }

    @Override
    public String toString() {
        return "DichVu{" +
                "maDichVu: '" + maDichVu + '\'' +
                ", tenDichVu: '" + tenDichVu + '\'' +
                ", giaDichVu: " + giaDichVu +
                '}';
    }
}