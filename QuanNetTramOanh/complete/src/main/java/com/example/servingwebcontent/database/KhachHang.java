package com.example.quannet.database;

public class KhachHang {
    private int id;
    private String ten;
    private String sdt;
    private int diemTichLuy;
    
    public KhachHang(int id, String ten, String sdt) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = 0;
    }
    
    // Tích điểm khi sử dụng dịch vụ
    public void tangDiem(int diem) {
        this.diemTichLuy += diem;
    }
    
    // Getter methods
    public int getId() { return id; }
    public String getTen() { return ten; }
}