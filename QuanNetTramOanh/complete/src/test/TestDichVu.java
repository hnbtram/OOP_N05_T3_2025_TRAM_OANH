import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DichVuTest {
    
    @Test
    public void testDichVuConstructorAndGetters() {
        DichVu dv = new DichVu("DV001", "Vệ sinh laptop", 200000);
        
        assertEquals("DV001", dv.getMaDichVu());
        assertEquals("Vệ sinh laptop", dv.getTenDichVu());
        assertEquals(200000, dv.getGiaDichVu());
    }
    
    @Test
    public void testDichVuSetters() {
        DichVu dv = new DichVu();
        dv.setMaDichVu("DV002");
        dv.setTenDichVu("Cài đặt phần mềm");
        dv.setGiaDichVu(150000);
        
        assertEquals("DV002", dv.getMaDichVu());
        assertEquals("Cài đặt phần mềm", dv.getTenDichVu());
        assertEquals(150000, dv.getGiaDichVu());
    }
    
    @Test
    public void testDichVuToString() {
        DichVu dv = new DichVu("DV003", "Thay bàn phím", 300000);
        String expected = "DichVu{maDichVu=DV003, tenDichVu=Thay bàn phím, giaDichVu=300000}";
        
        assertEquals(expected, dv.toString());
    }
}