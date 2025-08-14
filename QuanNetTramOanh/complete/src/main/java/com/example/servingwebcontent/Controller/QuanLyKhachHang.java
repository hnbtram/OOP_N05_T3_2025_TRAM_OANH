package com.example.servingwebcontent.Controller;
import java.util.ArrayList;
import java.util.List;
import com.example.servingwebcontent.Model.KhachHang;
public class QuanLyKhachHang {
    private List<KhachHang> danhSachKhachHang;

    public QuanLyKhachHang() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    public void themKhachHang(KhachHang khachHang) {
        danhSachKhachHang.add(khachHang);
    }

    public boolean xoaKhachHang(String maKhachHang) {
        return danhSachKhachHang.removeIf(kh -> kh.getMaKhachHang().equals(maKhachHang));
    }

    public KhachHang timKhachHang(String maKhachHang) {
        return danhSachKhachHang.stream()
                .filter(kh -> kh.getMaKhachHang().equals(maKhachHang))
                .findFirst()
                .orElse(null);
    }

    public boolean capNhatKhachHang(String maKhachHang, KhachHang khachHangMoi) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKhachHang().equals(maKhachHang)) {
                kh.setTenKhachHang(khachHangMoi.getTenKhachHang());
                kh.setSoDienThoai(khachHangMoi.getSoDienThoai());
                // Nếu có thuộc tính khác cần cập nhật, thêm vào đây
                return true;
            }
        }
        return false;
    }
    
    public List<KhachHang> getDanhSachKhachHang() {
        return new ArrayList<>(danhSachKhachHang);
    }

    public boolean napTien(String maKhachHang, double soTien) {
        KhachHang kh = timKhachHang(maKhachHang);
        if (kh != null) {
            kh.napTien(soTien);
            return true;
        }
        return false;
    }
    public void lichSuDichVu(String maKhachHang) {
        KhachHang kh = timKhachHang(maKhachHang);
        if (kh != null) {
            System.out.println("Lịch sử dịch vụ của " + kh.getTenKhachHang() + ":");
            for (String dichVu : kh.getLichSuDichVu()) {
                System.out.println("- " + dichVu);
            }
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKhachHang);
        }
    }
    
}