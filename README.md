

<h1 align="center">Ứng Dụng Quản Lý Quán Net 👩🏻‍❤️‍👩🏻 </h1>
<p align="center">
  📚 <strong>Java OOP Project</strong> – Nhóm 3: <code>OOP_N05_T3_2025_GROUP_Tram_Oanh</code><br>


## 📍 Giới thiệu Dự án

**Ứng dụng Quản lý Quán Net** là giải pháp phần mềm toàn diện giúp chủ quán net quản lý hoạt động kinh doanh một cách hiệu quả và chuyên nghiệp.

### 🌟 Tính năng nổi bật


#### 👤 Quản lý Khách hàng
- 📝 Đăng ký/Chỉnh sửa thông tin khách hàng
- 💳 Hệ thống thẻ thành viên tích điểm
- 📊 Theo dõi lịch sử giao dịch
- 🛎️ Quản lý yêu cầu dịch vụ kèm theo

#### 🖥️ Quản lý Máy tính
- � Phân loại theo trạng thái (Đang hoạt động / Bảo trì / Trống)
- ⚙️ Quản lý cấu hình phần cứng
- 📦 Kiểm soát phần mềm cài đặt sẵn
- ⏱️ Tính giờ sử dụng tự động

#### 💰 Hệ thống Thanh toán
- 🧮 Tính tiền theo thời gian chơi
- 📈 Cộng dồn dịch vụ phát sinh
- 🖨️ Xuất hóa đơn chi tiết
- 📉 Cảnh báo số dư thấp

## 🛠️ Kiến trúc Hệ thống

```mermaid
Sơ đồ chức năng ( sơ đồ liên quan đến 3 chức năng )
classDiagram
    class KhachHang{
        +String maKH
        +String tenKH
        +String sdt
        +double soDu
        +List<DichVu> dichVuSuDung
        +themDichVu()
        +napTien()
    }
    
    class MayTinh{
        +String maMay
        +String hangSanXuat
        +String cauHinh
        +String trangThai
        +double giaTien
        +List<String> phanMem
        +LocalDateTime thoiGianBatDau
    }
    
    class ThanhToan{
        +KhachHang khachHang
        +MayTinh mayTinh
        +List<DichVu> dichVu
        +tinhTongTien()
        +inHoaDon()
    }
    
    KhachHang "1" -- "n" ThanhToan
    MayTinh "1" -- "1" ThanhToan
```

## 🚀 Công nghệ sử dụng
- **Ngôn ngữ**: Java 17
- **Mô hình**: OOP 
- **Lưu trữ**: File text 

## 👩‍💻 Thành viên nhóm
| STT | Họ tên | MSSV | Github | Liên hệ |
|-----|--------|------|---------|-----------|
| 1 | Hoàng Nhật Bảo Trâm | 24100260 | https://github.com/hnbtram | 24100260@st.phenikaa-uni.edu.vn |
| 2 | Nguyễn Thị Kim Oanh | 24100459 | https://github.com/oanhmau | 24100459@st.phenikaa-uni.edu.vn |

## 📞 Liên hệ
- **Giảng viên hướng dẫn**: Nguyễn Lệ Thu
- **Lớp**: OOP_N05 - Kỳ 3 năm 2025

<p align="center">
  <em>Dự án được phát triển vì mục đích học tập</em>
</p>
