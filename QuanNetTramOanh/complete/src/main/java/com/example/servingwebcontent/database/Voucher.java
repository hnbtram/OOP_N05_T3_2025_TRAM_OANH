package com.example.servingwebcontent.database;

import java.time.LocalDate;

public class Voucher {
    private String maVoucher;
    private double giaTri;
    private LocalDate hanSuDung;
    
    // Thêm getters và setters
    public String getMaVoucher() { return maVoucher; }
    public void setMaVoucher(String maVoucher) { this.maVoucher = maVoucher; }
    
    public double getGiaTri() { return giaTri; }
    public void setGiaTri(double giaTri) { this.giaTri = giaTri; }
    
    public LocalDate getHanSuDung() { return hanSuDung; }
    public void setHanSuDung(LocalDate hanSuDung) { this.hanSuDung = hanSuDung; }
    
    // Thêm phương thức sử dụng các trường
    public boolean isValid() {
        return LocalDate.now().isBefore(hanSuDung);
    }
    
    public double applyDiscount(double totalAmount) {
        if (isValid()) {
            return totalAmount * (1 - giaTri / 100); // Giả sử giáTri là %
        }
        return totalAmount;
    }
    
    public String getThongTin() {
        return String.format("Voucher %s: Giảm %.2f%% - HSD: %s",
                           maVoucher, giaTri, hanSuDung);
    }
}