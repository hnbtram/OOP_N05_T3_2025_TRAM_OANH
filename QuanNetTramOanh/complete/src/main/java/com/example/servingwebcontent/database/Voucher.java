public class Voucher {
    private String maVoucher;
    private double giaTri; // % hoặc số tiền
    private LocalDate hanSuDung;
    
    public boolean isValid() {
        return LocalDate.now().isBefore(hanSuDung);
    }
}