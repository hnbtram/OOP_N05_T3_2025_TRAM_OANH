package com.example.quannet.database;

public class MayTinh {
    private int id;
    private String tenMay;
    private String cauHinh; // CPU, RAM, VGA...
    private String trangThai; // "dang_hoat_dong", "bao_tri", "trong"
    private double giaTheoGio;
    
    // Constructor
    public MayTinh(int id, String tenMay, String cauHinh, double giaTheoGio) {
        this.id = id;
        this.tenMay = tenMay;
        this.cauHinh = cauHinh;
        this.trangThai = "trong";
        this.giaTheoGio = giaTheoGio;
    }
    
    // Getter methods
    public int getId() { return id; }
    public String getTrangThai() { return trangThai; }
    
    // Phương thức tính tiền
    public double tinhTien(int gioSuDung) {
        return giaTheoGio * gioSuDung;
    }
}