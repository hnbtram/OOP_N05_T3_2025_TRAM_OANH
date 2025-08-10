package com.example.servingwebcontent;
import com.example.servingwebcontent.Controller.DichVuService;
import com.example.servingwebcontent.Model.DichVu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DichVuServiceTest {

    private DichVuService dichVuService;
    private DichVu dv1, dv2;

    @BeforeEach
    void setUp() {
        dichVuService = new DichVuService();
        
        // Tạo dữ liệu test
        dv1 = new DichVu("DV001", "Internet", 50000, "Giờ");
        dv2 = new DichVu("DV002", "Nước uống", 20000, "Chai");
        
        dichVuService.themDichVu(dv1);
    }

    @Test
    void themDichVu_ThanhCong() {
        DichVu result = dichVuService.themDichVu(dv2);
        assertEquals(dv2, result);
        assertEquals(2, dichVuService.layTatCaDichVu().size());
    }

    @Test
    void layTatCaDichVu_CoDuLieu() {
        List<DichVu> result = dichVuService.layTatCaDichVu();

        assertEquals(2, result.size());
        assertEquals(dv1, result.get(0));
        assertEquals(dv2, result.get(0));
        assertTrue(result.contains(dv1));
        assertTrue(result.contains(dv2));
    }

    @Test
    void timTheoMa_TonTai() {
        Optional<DichVu> result = dichVuService.timTheoMa("DV001");
        assertTrue(result.isPresent());
        assertEquals(dv1, result.get());
    }

    @Test
    void timTheoMa_KhongTonTai() {
        Optional<DichVu> result = dichVuService.timTheoMa("DV999");
        assertTrue(result.isEmpty());
    }

    @Test
    void capNhatDichVu_ThanhCong() {
        DichVu updateData = new DichVu("DV001", "Internet VIP", 70000, "Giờ");
        boolean result = dichVuService.capNhatDichVu("DV001", updateData);
        
        assertTrue(result);
        DichVu updated = dichVuService.timTheoMa("DV001").get();
        assertEquals("Internet VIP", updated.getTenDichVu());
        assertEquals(70000, updated.getGiaDichVu());
    }

    @Test
    void capNhatDichVu_KhongTonTai() {
        DichVu updateData = new DichVu("DV999", "Không tồn tại", 0, "Lần");
        boolean result = dichVuService.capNhatDichVu("DV999", updateData);
        assertFalse(result);
    }

    @Test
    void xoaDichVu_ThanhCong() {
        boolean result = dichVuService.xoaDichVu("DV001");
        assertTrue(result);
        assertFalse(dichVuService.timTheoMa("DV001").get().isTrangThai());
    }

    @Test
    void xoaDichVu_KhongTonTai() {
        boolean result = dichVuService.xoaDichVu("DV999");
        assertFalse(result);
    }

    @Test
    void layDichVuDangHoatDong() {
        dichVuService.themDichVu(dv2);
        dichVuService.xoaDichVu("DV001"); // Đánh dấu không hoạt động
        
        List<DichVu> result = dichVuService.layDichVuDangHoatDong();
        assertEquals(1, result.size());
        assertEquals(dv2, result.get(0));
    }

    @Test
    void kiemTraTonTai_Co() {
        assertTrue(dichVuService.kiemTraTonTai("DV001"));
    }

    @Test
    void kiemTraTonTai_Khong() {
        assertFalse(dichVuService.kiemTraTonTai("DV999"));
    }
}