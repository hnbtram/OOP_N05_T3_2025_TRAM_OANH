package com.example.servingwebcontent;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MayTinhTest {
    
    @Test
    public void testMayTinhConstructorAndGetters() {
        MayTinh mt = new MayTinh();
        
        assertEquals("MT001", mt.getMaMayTinh());
        assertEquals("Dell XPS 15", mt.getMaMayTinh());
        assertEquals("Dell", mt.getHangSanXuat());
        assertEquals("2020", mt.getHangSanXuat());
    }
    
    @Test
    public void testMayTinhSetters() {
        MayTinh mt = new MayTinh();
        mt.setMaMayTinh("MT002");
        mt.setMaMayTinh("MacBook Pro");
        mt.setHangSanXuat("Apple");
        mt.setHangSanXuat("2021");
        
        assertEquals("MT002", mt.getMaMayTinh());
        assertEquals("MacBook Pro", mt.getMaMayTinh());
        assertEquals("Apple", mt.getHangSanXuat());
        assertEquals("2021", mt.getHangSanXuat());
    }
    
    @Test
    public void testMayTinhToString() {
        MayTinh mt = new MayTinh();
        String expected = "MayTinh{maMayTinh=MT003, tenMayTinh=Asus Zenbook, hangSanXuat=Asus, namSanXuat=2019}";
        
        assertEquals(expected, mt.toString());
    }
}