package com.example.servingwebcontent.database;

public class DichVu {
    private int id;
    private String tenDV;
    private String moTa;
    private double donGia;
    private String donViTinh;
    private LoaiDichVu loaiDV;
    private boolean tinhTheoGio;  // true nếu tính theo giờ (ví dụ: giờ chơi máy)

    // Các loại dịch vụ đặc trưng của quán net
    public enum LoaiDichVu {
        GIO_CHOI("Giờ chơi"),
        NUOC_UONG("Nước uống"),
        DO_AN_NHANH("Đồ ăn nhanh"),
        THE_NAP("Thẻ nạp game"),
        KHAC("Dịch vụ khác");

        private final String displayName;

        LoaiDichVu(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    // Constructor cho dịch vụ giờ chơi
    public DichVu(int id, String tenDV, double donGiaTheoGio) {
        this.id = id;
        this.tenDV = tenDV;
        this.donGia = donGiaTheoGio;
        this.loaiDV = LoaiDichVu.GIO_CHOI;
        this.donViTinh = "giờ";
        this.tinhTheoGio = true;
        this.moTa = "Dịch vụ thuê máy tính theo giờ";
    }

    // Constructor cho đồ ăn/thức uống
    public DichVu(int id, String tenDV, double donGia, LoaiDichVu loaiDV, String donViTinh) {
        this.id = id;
        this.tenDV = tenDV;
        this.donGia = donGia;
        this.loaiDV = loaiDV;
        this.donViTinh = donViTinh;
        this.tinhTheoGio = false;
        this.moTa = (loaiDV == LoaiDichVu.NUOC_UONG) ? "Thức uống giải khát" : "Đồ ăn nhanh";
    }

    // Constructor đầy đủ
    public DichVu(int id, String tenDV, String moTa, double donGia, 
                 String donViTinh, LoaiDichVu loaiDV, boolean tinhTheoGio) {
        this.id = id;
        this.tenDV = tenDV;
        this.moTa = moTa;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.loaiDV = loaiDV;
        this.tinhTheoGio = tinhTheoGio;
    }

    // Tính tiền dịch vụ (đặc biệt cho giờ chơi)
    public double tinhTien(double soLuong) {
        if (tinhTheoGio) {
            return donGia * Math.ceil(soLuong); // Làm tròn lên theo giờ
        }
        return donGia * soLuong;
    }

    // Hiển thị giá theo định dạng phù hợp
    public String getGiaFormatted() {
        if (tinhTheoGio) {
            return String.format("%,.0f VND/giờ", donGia);
        }
        return String.format("%,.0f VND/%s", donGia, donViTinh);
    }

    // Getter và Setter
    public String getMaDichVu() {
        return "DV" + String.format("%04d", id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public LoaiDichVu getLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(LoaiDichVu loaiDV) {
        this.loaiDV = loaiDV;
    }

    public boolean isTinhTheoGio() {
        return tinhTheoGio;
    }

    public void setTinhTheoGio(boolean tinhTheoGio) {
        this.tinhTheoGio = tinhTheoGio;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s", getMaDichVu(), tenDV, getGiaFormatted());
    }
}