public class testkhachHang {
    public static void test(){
        KhachHang kh = new KhachHang(1, "Nguyen Van A", "0123456789");

    kh.hienthi();
    // Test fields (should use getters of available)
    assert kh.maKH == 1 : "maKH should be 1";
    assert kh.tenKH.equals("Nguyen Van A") : "tenKH should be 'Nguyen Van A'" ;
    assert kh.sdt.equals("0123456789") : "sdt should be '0123456789' ";

    System.out.println("all tests passed for KhachHang.");
    }
}