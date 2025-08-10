package com.example.servingwebcontent.database;

public class KhachHang {
    private int id;          // Sẽ dùng trong getMaKhach()
    private String ten;
    private String sdt;
    private int diemTichLuy;

    public KhachHang(int id, String ten, String sdt) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = 0;
    }

    public KhachHang(String string, String string2, String string3, String string4) {
        // Constructor for creating a KhachHang object with specific parameters
        this.id = Integer.parseInt(string); // Assuming string is a valid integer ID
        this.ten = string2;
        this.sdt = string3;
        this.diemTichLuy = Integer.parseInt(string4); // Assuming string4 is a valid integer for diemTichLuy
    }

    // Phương thức mới sử dụng id
    public String getMaKhach() {
        return "KH" + String.format("%04d", id); // Ví dụ: KH0001
    }

    // Sử dụng tất cả các trường
    public String getThongTinDayDu() {
        return String.format("%s - %s | Điểm: %d | Mã KH: %s", 
               ten, sdt, diemTichLuy, getMaKhach());
    }

    public void tangDiem(int diem) {
        this.diemTichLuy += diem;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    public Object getSoDienThoai() {
        return sdt;
    }

    public Object getTenKhachHang() {
        return ten;
    }
    public void setTenKhachHang(String ten) {
        this.ten = ten;
    }

    public void setMaKhachHang(String string) {
       
      
    }

    public void setSoDienThoai(String string) {
        this.sdt = string;
    }

    public String getMaKhachHang() {
        return getMaKhach();
    }

}