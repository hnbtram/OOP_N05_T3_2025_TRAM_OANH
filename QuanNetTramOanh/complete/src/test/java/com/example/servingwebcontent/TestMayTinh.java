import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MayTinhTest {
    
    @Test
    public void testMayTinhConstructorAndGetters() {
        MayTinh mt = new MayTinh("MT001", "Dell XPS 15", "Dell", "2020");
        
        assertEquals("MT001", mt.getMaMayTinh());
        assertEquals("Dell XPS 15", mt.getTenMayTinh());
        assertEquals("Dell", mt.getHangSanXuat());
        assertEquals("2020", mt.getNamSanXuat());
    }
    
    @Test
    public void testMayTinhSetters() {
        MayTinh mt = new MayTinh();
        mt.setMaMayTinh("MT002");
        mt.setTenMayTinh("MacBook Pro");
        mt.setHangSanXuat("Apple");
        mt.setNamSanXuat("2021");
        
        assertEquals("MT002", mt.getMaMayTinh());
        assertEquals("MacBook Pro", mt.getTenMayTinh());
        assertEquals("Apple", mt.getHangSanXuat());
        assertEquals("2021", mt.getNamSanXuat());
    }
    
    @Test
    public void testMayTinhToString() {
        MayTinh mt = new MayTinh("MT003", "Asus Zenbook", "Asus", "2019");
        String expected = "MayTinh{maMayTinh=MT003, tenMayTinh=Asus Zenbook, hangSanXuat=Asus, namSanXuat=2019}";
        
        assertEquals(expected, mt.toString());
    }
}