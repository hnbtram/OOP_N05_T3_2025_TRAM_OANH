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
}