public class May {
    int MaMay;
    String TenMay;
    String HangMay;
    int GiaGioChoi;
    int SoGioDaChoi;
    int TongTien;
    int SoGioConLai;

    public May(int MaMay, String TenMay, String HangMay, int GiaGioChoi, int SoGioDaChoi, int TongTien, int SoGioConLai){
        this.MaMay = MaMay;
        this.TenMay = TenMay;
        this.HangMay = HangMay;
        this.GiaGioChoi = GiaGioChoi;
        this.SoGioDaChoi = SoGioDaChoi;
        this.TongTien = TongTien;
        this.SoGioConLai = SoGioConLai;


    }
    public void hienthi() {
        System.out.println("Ten May:" + TenMay);
        System.out.println("Hang May:" + HangMay);
        System.out.println("Gia Gio Choi:"+ GiaGioChoi);
        System.out.println("So Gio Da Choi:" +SoGioDaChoi);
<<<<<<< HEAD
        System.out.println("Ma May:" + MaMay);
        System.out.println("So Gio Con Lai:" + SoGioConLai);
        System.out.println("Tong Tien:" + TongTien);
=======

>>>>>>> 388910cf9fc844f89ef9f82d49ea495e15a6f476
        System.out.println("Tong Tien:" +TongTien);


        System.out.println("Tong Tien:" +TongTien);
        System.out.println("Tong Tien:" +TongTien);


        System.out.println("So Gio Con Lai:" +SoGioConLai);

    }
      public int getMaMay() {
        return MaMay;
    }

    public String getTenMay() {
        return TenMay;
    }

    public String getHangMay() {
        return HangMay;
    }

    public int getGiaGioChoi() {
        return GiaGioChoi;
    }

    public int getSoGioDaChoi() {
        return SoGioDaChoi;
    }

    public int getTongTien() {
        return TongTien;
    }

    public int getSoGioConLai() {
        return SoGioConLai;
    }

}