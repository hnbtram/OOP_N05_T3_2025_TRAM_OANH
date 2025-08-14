package com.example.servingwebcontent.Controller;
import com.example.servingwebcontent.Model.DichVu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DichVuService {
    private final List<DichVu> danhSachDichVu = new ArrayList<>();

    public DichVu themDichVu(DichVu dichVu) {
        danhSachDichVu.add(dichVu);
        return dichVu;
    }

    public List<DichVu> layTatCaDichVu() {
        return new ArrayList<>(danhSachDichVu);
    }

    public Optional<DichVu> timTheoMa(String maDichVu) {
        return danhSachDichVu.stream()
                .filter(dv -> dv.getMaDichVu().equals(maDichVu))
                .findFirst();
    }

    public boolean capNhatDichVu(String maDichVu, DichVu dichVuMoi) {
        Optional<DichVu> dichVuCu = timTheoMa(maDichVu);
        if (dichVuCu.isPresent()) {
            DichVu dv = dichVuCu.get();
            dv.setTenDichVu(dichVuMoi.getTenDichVu());      // Đảm bảo setTenDichVu nhận String
            dv.setGiaDichVu(dichVuMoi.getGiaDichVu());      // Đảm bảo setGiaDichVu nhận double
            dv.setDonViTinh(dichVuMoi.getDonViTinh());
            dv.setTrangThai(dichVuMoi.isTrangThai());
            return true;
        }
        return false;
    }

    public boolean xoaDichVu(String maDichVu) {
        Optional<DichVu> dichVu = timTheoMa(maDichVu);
        if (dichVu.isPresent()) {
            dichVu.get().setTrangThai(false);
            return true;
        }
        return false;
    }

    // Additional business methods
    public List<DichVu> layDichVuDangHoatDong() {
        return danhSachDichVu.stream()
                .filter(DichVu::isTrangThai)
                .toList();
    }

    public boolean kiemTraTonTai(String maDichVu) {
        return danhSachDichVu.stream()
                .anyMatch(dv -> dv.getMaDichVu().equals(maDichVu));
    }
}