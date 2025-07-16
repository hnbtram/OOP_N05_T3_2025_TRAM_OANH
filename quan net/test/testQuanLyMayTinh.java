// Class demo để test chương trình
public class testQuanLyMayTinh {
    public static void main(String[] args) {
        // Tạo quản lý máy tính
        QuanLyMayTinh qlmt = new QuanLyMayTinh();
        
        // Thêm các máy tính
        MayTinh may1 = new MayTinh("MT001", "Máy Gaming 1", 25000);
        MayTinh may2 = new MayTinh("MT002", "Máy Văn phòng 1", 15000);
        qlmt.themMayTinh(may1);
        qlmt.themMayTinh(may2);
        
        // Thêm phần mềm vào máy
        may1.themPhanMem("Liên Minh Huyền Thoại");
        may1.themPhanMem("Valorant");
        may2.themPhanMem("Microsoft Office");
        
        // Hiển thị danh sách phần mềm
        may1.hienThiDanhSachPhanMem();
        
        // Thay đổi trạng thái máy
        may2.thayDoiTrangThai(MayTinh.TrangThaiMay.BAO_TRI);
        
        // Sử dụng máy
        may1.batDauSuDung();
        try {
            // Giả lập thời gian sử dụng (đợi 2 giây)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        may1.ketThucSuDung();
        
        // Tính chi phí
        System.out.println("Chi phí sử dụng máy " + may1.getMaMay() + ": " + may1.tinhChiPhi() + " VND");
        
        // Hiển thị tất cả máy
        qlmt.hienThiTatCaMayTinh();
        
        // Thống kê trạng thái
        qlmt.thongKeTheoTrangThai();
    }
}