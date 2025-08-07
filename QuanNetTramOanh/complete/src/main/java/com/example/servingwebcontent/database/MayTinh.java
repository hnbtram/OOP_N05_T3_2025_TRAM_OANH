package com.example.servingwebcontent.database;

public class MayTinh {
    private int id;          // Sẽ dùng trong getMaMay()
    private String tenMay;
    private String cauHinh;
    private String trangThai; // Sẽ dùng trong kiemTraTrangThai()
    private double giaTheoGio;

    public MayTinh(int id, String tenMay, String cauHinh, double giaTheoGio) {
        this.id = id;
        this.tenMay = tenMay;
        this.cauHinh = cauHinh;
        this.trangThai = "trong"; // Mặc định là trống
        this.giaTheoGio = giaTheoGio;
    }

    // Phương thức mới sử dụng id
    public String getMaMay() {
        return "MT" + String.format("%03d", id); // Ví dụ: MT001
    }

    // Phương thức sử dụng trangThai
    public boolean kiemTraTrangThai() {
        return !"bao_tri".equals(trangThai);
    }

    // Sử dụng tất cả các trường
    public String getThongTinMay() {
        return String.format("%s - %s | %s | Giá: %.0f/h | Trạng thái: %s", 
               getMaMay(), tenMay, cauHinh, giaTheoGio, trangThai);
    }

    // Setter cho trangThai
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Getter cho id
    public int getId() {
        return id;
    }
}