package com.example.servingwebcontent;

import com.example.servingwebcontent.Model.KhachHang;
import com.example.servingwebcontent.Controller.QuanLyKhachHang;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class QuanLyKhachHangTest {
    private QuanLyKhachHang qlkh;
    private KhachHang kh1, kh2;
    
    @BeforeEach
    void setUp() {
        qlkh = new QuanLyKhachHang();
        kh1 = new KhachHang("KH001", "Nguyen Van A", "0123456789");
        kh2 = new KhachHang("KH002", "Tran Thi B", "0987654321");
        
        qlkh.themKhachHang(kh1);
        qlkh.themKhachHang(kh2);
    }
    
    @Test
    void testThemKhachHang() {
        assertEquals(1, qlkh.getDanhSachKhachHang().size());
    }
    
    @Test
    void testXoaKhachHang() {
        assertTrue(qlkh.xoaKhachHang("KH001"));
        assertEquals(1, qlkh.getDanhSachKhachHang().size());
        assertFalse(qlkh.xoaKhachHang("KH999")); // Không tồn tại
    }
    
    @Test
    void testTimKhachHang() {
        assertEquals(kh1, qlkh.timKhachHang("KH001"));
        assertNull(qlkh.timKhachHang("KH999")); // Không tồn tại
    }
    
    @Test
    void testNapTien() {
        assertTrue(qlkh.napTien("KH001", 100000));
        assertFalse(qlkh.napTien("KH999", 50000)); // Không tồn tại
    }
    
    @Test
    void testGetDanhSachKhachHang() {
        List<KhachHang> ds = qlkh.getDanhSachKhachHang();
        assertEquals(1, ds.size());
        assertTrue(ds.contains(kh1) && ds.contains(kh2));
    }
    
    @Test
    void testLichSuDichVu() {
        qlkh.lichSuDichVu("KH001");
        qlkh.lichSuDichVu("KH999"); // Không tồn tại
    }
}