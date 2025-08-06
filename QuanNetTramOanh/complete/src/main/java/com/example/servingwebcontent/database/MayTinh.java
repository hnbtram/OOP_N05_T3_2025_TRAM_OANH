package com.example.servingwebcontent.database;

import java.util.List;

public class MayTinh {
    private int id;
    private String tenMay;
    private String cauHinh;
    private String trangThai;
    private double giaTheoGio;
    
    // Thêm getters và setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTenMay() { return tenMay; }
    public void setTenMay(String tenMay) { this.tenMay = tenMay; }
    
    public String getCauHinh() { return cauHinh; }
    public void setCauHinh(String cauHinh) { this.cauHinh = cauHinh; }
    
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
    
    public double getGiaTheoGio() { return giaTheoGio; }
    public void setGiaTheoGio(double giaTheoGio) { this.giaTheoGio = giaTheoGio; }
    
    // Thêm phương thức sử dụng các trường
    public boolean isAvailable() {
        return "san_sang".equals(trangThai);
    }
    
    public double tinhTien(int gioSuDung) {
        return giaTheoGio * gioSuDung;
    }
    
    public String getThongTin() {
        return String.format("Máy %d: %s - %s - Giá: %.2f/h - Trạng thái: %s",
                           id, tenMay, cauHinh, giaTheoGio, trangThai);
    }
    
    public List<MayTinh> getAvailableComputers() {
        // Implementation
        return null;
    }
}