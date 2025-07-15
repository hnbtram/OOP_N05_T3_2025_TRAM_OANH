public class testMay {
    public static void test(){
       may m = new may("1", "May A", "Hang A", 10000, 2, 20000, 1);
        m.hienthi();
        
        // Test getter methods
        System.out.println("Ma May: " + m.getMaMay());
        System.out.println("Ten May: " + m.getTenMay());
        System.out.println("Hang May: " + m.getHangMay());
        System.out.println("Gia Gio Choi: " + m.getGiaGioChoi());
        System.out.println("So Gio Da Choi: " + m.getSoGioDaChoi());
        System.out.println("Tong Tien: " + m.getTongTien());
        System.out.println("So Gio Con Lai: " + m.getSoGioConLai());
    }
}

         