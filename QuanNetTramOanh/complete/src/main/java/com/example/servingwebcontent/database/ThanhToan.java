package com.example.servingwebcontent.database;

import java.time.LocalDateTime;

public class ThanhToan {
    private int id;  // Đã thêm sử dụng trong getMaHoaDon()
    private int mayTinhId;  // Đã thêm sử dụng trong constructor và getThongTin()
    private int khachHangId;  // Đã thêm sử dụng trong constructor và getThongTin()
    private LocalDateTime thoiGianBatDau;
    private double tongTien;  // Đã thêm sử dụng trong ketThuc() và getThongTin()

    // Constructor
    public ThanhToan(int id, int mayTinhId, int khachHangId) {
        this.id = id;
        this.mayTinhId = mayTinhId;
        this.khachHangId = khachHangId;
        this.thoiGianBatDau = LocalDateTime.now();
    }

    // Thêm phương thức sử dụng các trường
    public void ketThuc(double giaTheoGio) {
        long gioSuDung = java.time.Duration.between(thoiGianBatDau, LocalDateTime.now()).toHours();
        this.tongTien = giaTheoGio * gioSuDung;
    }

    public String getThongTin() {
        return "HĐ " + id + " | Máy " + mayTinhId + " | KH " + khachHangId + " | Tổng: " + tongTien;
    }

    public String getMaHoaDon() {
        return "HD" + String.format("%04d", id);
    }
}