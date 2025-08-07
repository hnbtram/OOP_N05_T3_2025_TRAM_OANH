package com.example.quannet.database;

import java.time.LocalDateTime;

public class ThanhToan {
    private int id;
    private int mayTinhId;
    private int khachHangId;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private double tongTien;
    
    public ThanhToan(int mayTinhId, int khachHangId) {
        this.mayTinhId = mayTinhId;
        this.khachHangId = khachHangId;
        this.thoiGianBatDau = LocalDateTime.now();
    }
    
    // Tính tiền khi kết thúc
    public void ketThucSuDung(double giaTheoGio) {
        this.thoiGianKetThuc = LocalDateTime.now();
        long gioSuDung = java.time.Duration.between(thoiGianBatDau, thoiGianKetThuc).toHours();
        this.tongTien = giaTheoGio * gioSuDung;
    }
}