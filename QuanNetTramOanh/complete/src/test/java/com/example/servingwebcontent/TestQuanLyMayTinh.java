package com.example.servingwebcontent;

import com.example.servingwebcontent.Model.MayTinh;
import com.example.servingwebcontent.Controller.QuanLyMayTinh;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuanLyMayTinhTest {
    private QuanLyMayTinh quanLy;
    private MayTinh may1, may2;

    @BeforeEach
    void setUp() {
        quanLy = new QuanLyMayTinh();
        may1 = new MayTinh(101, 25000);
        may2 = new MayTinh(102, 35000);
        quanLy.themMayTinh(may1);
        quanLy.themMayTinh(may2);
    }

    @Test
    void testThemMayTinh() {
        assertEquals(2, quanLy.getDanhSachMayTinh().size());
    }

    @Test
    void testTimMayTinh() {
        assertEquals(may1, quanLy.timMayTinh(101));
        assertNull(quanLy.timMayTinh(999));
    }

    @Test
    void testCapNhatGia() {
        assertTrue(quanLy.capNhatGiaMayTinh(101, 30000));
        assertEquals(30000, quanLy.timMayTinh(101).getGiaTienTheoGio());
    }

    @Test
    void testBatDauSuDung() {
        assertTrue(quanLy.batDauSuDungMay(102, "KH001"));
        assertFalse(quanLy.batDauSuDungMay(999, "KH001")); // ID không tồn tại
    }

    @Test
    void testKetThucSuDung() {
        quanLy.batDauSuDungMay(102, "KH001");
        double tien = quanLy.ketThucSuDungMay(102);
        assertTrue(tien > 0);
    }

    @Test
    void testXoaMayTinh() {
        assertTrue(quanLy.xoaMayTinh(101));
        assertEquals(1, quanLy.getDanhSachMayTinh().size());
    }
}