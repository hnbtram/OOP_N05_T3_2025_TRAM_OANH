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
        System.out.println("MaMay: " + MaMay);
        System.out.println("TenMay: " + TenMay);
        System.out.println("HangMay: " + HangMay);
        System.out.println("GiaGioChoi: " + GiaGioChoi);
        System.out.println("SoGioDaChoi: " + SoGioDaChoi);
        System.out.println("TongTien: " + TongTien);
        System.out.println("SoGioConLai: " + SoGioConLai);
    }

}