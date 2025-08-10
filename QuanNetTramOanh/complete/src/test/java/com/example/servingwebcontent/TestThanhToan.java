import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ThanhToanTest {
    
    @Test
    public void testThanhToanConstructorAndGetters() {
        Date ngayThanhToan = new Date();
        ThanhToan tt = new ThanhToan("TT001", "HD001", 500000, ngayThanhToan, "Chuyển khoản");
        
        assertEquals("TT001", tt.getMaThanhToan());
        assertEquals("HD001", tt.getMaHoaDon());
        assertEquals(500000, tt.getSoTien());
        assertEquals(ngayThanhToan, tt.getNgayThanhToan());
        assertEquals("Chuyển khoản", tt.getPhuongThuc());
    }
    
    @Test
    public void testThanhToanSetters() {
        Date ngayThanhToan = new Date();
        ThanhToan tt = new ThanhToan();
        tt.setMaThanhToan("TT002");
        tt.setMaHoaDon("HD002");
        tt.setSoTien(750000);
        tt.setNgayThanhToan(ngayThanhToan);
        tt.setPhuongThuc("Tiền mặt");
        
        assertEquals("TT002", tt.getMaThanhToan());
        assertEquals("HD002", tt.getMaHoaDon());
        assertEquals(750000, tt.getSoTien());
        assertEquals(ngayThanhToan, tt.getNgayThanhToan());
        assertEquals("Tiền mặt", tt.getPhuongThuc());
    }
    
    @Test
    public void testThanhToanToString() {
        Date ngayThanhToan = new Date();
        ThanhToan tt = new ThanhToan("TT003", "HD003", 1000000, ngayThanhToan, "Thẻ tín dụng");
        String expected = "ThanhToan{maThanhToan=TT003, maHoaDon=HD003, soTien=1000000, ngayThanhToan=" + ngayThanhToan + ", phuongThuc=Thẻ tín dụng}";
        
        assertEquals(expected, tt.toString());
    }
}