package com.example.servingwebcontent.database;

public class DoAnUong {
    private int id;
    private String tenMon;
    private double gia;
    private String loai;
    private int tonKho;
    
    // Thêm getters và setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTenMon() { return tenMon; }
    public void setTenMon(String tenMon) { this.tenMon = tenMon; }
    
    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }
    
    public String getLoai() { return loai; }
    public void setLoai(String loai) { this.loai = loai; }
    
    public int getTonKho() { return tonKho; }
    public void setTonKho(int tonKho) { this.tonKho = tonKho; }
    
    // Thêm phương thức sử dụng các trường
    public boolean orderFood(int soLuong) {
        if (soLuong <= 0 || soLuong > tonKho) {
            return false;
        }
        tonKho -= soLuong;
        return true;
    }
    
    public String getThongTin() {
        return String.format("Món: %s (ID: %d) - Giá: %.2f - Tồn kho: %d", 
                           tenMon, id, gia, tonKho);
    }
}