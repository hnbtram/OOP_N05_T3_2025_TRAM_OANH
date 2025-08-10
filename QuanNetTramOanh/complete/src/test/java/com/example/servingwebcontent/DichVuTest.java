package com.example.servingwebcontent;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.servingwebcontent.Model.DichVu;

public class DichVuTest {
    
    @Test
    public void testDichVuConstructorAndGetters() {
        DichVu dv = new DichVu("DV001", "Vệ sinh laptop", 200000, null);
        
        assertEquals("DV001", dv.getMaDichVu());
        assertEquals("Vệ sinh laptop", dv.getTenDichVu());
        assertEquals(200000, dv.getGiaDichVu());
    }
    
    @Test
    public void testDichVuSetters() {
        DichVu dv = new DichVu(null, null, 0, null);
        dv.setGiaDichVu("DV002");
        dv.setGiaDichVu("Cài đặt phần mềm");
        dv.setTenDichVu(150000);
        
        assertEquals("DV002", dv.getMaDichVu());
        assertEquals("Cài đặt phần mềm", dv.getTenDichVu());
        assertEquals(150000, dv.getGiaDichVu());
    }
    
    @Test
    public void testDichVuToString() {
        DichVu dv = new DichVu("DV003", "Thay bàn phím", 300000, null);
        String expected = "DichVu{maDichVu=DV003, tenDichVu=Thay bàn phím, giaDichVu=300000}";
        
        assertEquals(expected, dv.toString());
    }
}