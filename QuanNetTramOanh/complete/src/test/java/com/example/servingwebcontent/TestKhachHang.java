import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KhachHangTest {
    
    @Test
    public void testKhachHangConstructorAndGetters() {
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn A", "0123456789", "a@gmail.com");
        
        assertEquals("KH001", kh.getMaKhachHang());
        assertEquals("Nguyễn Văn A", kh.getTenKhachHang());
        assertEquals("0123456789", kh.getSoDienThoai());
        assertEquals("a@gmail.com", kh.getEmail());
    }
    
    @Test
    public void testKhachHangSetters() {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang("KH002");
        kh.setTenKhachHang("Trần Thị B");
        kh.setSoDienThoai("0987654321");
        kh.setEmail("b@gmail.com");
        
        assertEquals("KH002", kh.getMaKhachHang());
        assertEquals("Trần Thị B", kh.getTenKhachHang());
        assertEquals("0987654321", kh.getSoDienThoai());
        assertEquals("b@gmail.com", kh.getEmail());
    }
    
    @Test
    public void testKhachHangToString() {
        KhachHang kh = new KhachHang("KH003", "Lê Văn C", "0369852147", "c@gmail.com");
        String expected = "KhachHang{maKhachHang=KH003, tenKhachHang=Lê Văn C, soDienThoai=0369852147, email=c@gmail.com}";
        
        assertEquals(expected, kh.toString());
    }
}