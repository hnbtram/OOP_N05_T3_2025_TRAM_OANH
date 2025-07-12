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
        System.out.println("Tong Tien:" +TongTien);
        System.out.println("So Gio Con Lai:" +SoGioConLai);

    }

}