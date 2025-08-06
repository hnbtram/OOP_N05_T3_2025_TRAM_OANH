public class KhachHang {
    private int id;
    private String ten;
    private String sdt;
    private int diemTichLuy;
    
    public void tangDiem(int diem) {
        this.diemTichLuy += diem;
    }
}