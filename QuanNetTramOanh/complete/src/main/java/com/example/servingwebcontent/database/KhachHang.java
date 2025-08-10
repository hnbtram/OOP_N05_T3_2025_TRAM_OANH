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
        //TODO Auto-generated constructor stub
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSoDienThoai'");
    }

    public Object getTenKhachHang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTenKhachHang'");
    }

    public Object getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public void setMaKhachHang(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMaKhachHang'");
    }

    public void setSoDienThoai(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSoDienThoai'");
    }

    public void setEmail(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    }
}