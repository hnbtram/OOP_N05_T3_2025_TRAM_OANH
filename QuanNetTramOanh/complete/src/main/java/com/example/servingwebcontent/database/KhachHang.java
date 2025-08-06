package com.example.servingwebcontent.database;

public class KhachHang {
    private int id;
    private String ten;
    private String sdt;
    private int diemTichLuy;
    
    // Thêm getters và setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    
    public int getDiemTichLuy() { return diemTichLuy; }
    
    // Thêm logic nghiệp vụ
    public void tangDiem(int diem) {
        if (diem > 0) {
            this.diemTichLuy += diem;
        }
    }
    
    public String getThongTin() {
        return String.format("KH: %s (ID: %d) - Điểm: %d - SĐT: %s", 
                           ten, id, diemTichLuy, sdt);
    }
}