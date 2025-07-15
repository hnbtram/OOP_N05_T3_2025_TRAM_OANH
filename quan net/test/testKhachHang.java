public class testKhachHang {
    public static void test() {
        KhachHang kh = new KhachHang("1", "Nguyen Van A", "123456789");
        kh.hienthi();
        

        // Test setter method

        kh.setTenKH("Tran Van B");
        System.out.println("Updated Ten khach hang: " + kh.getHoTen());
    }
}