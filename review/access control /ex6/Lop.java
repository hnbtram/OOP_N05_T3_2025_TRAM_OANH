public class Lop {
    protected String tenLop = "12A1";
    protected int siSo = 40;

    protected void HienThiThongTin(){
        System.out.println("Ten lop:" +tenLop);
        System.out.println("Si so: " +siSo);

    }

    
    
}
class TestLop {
    public static void main(String[] args){
        Lop lop = new Lop();
        System.out.println("Ten lop:" +lop.tenLop);
        System.out.println("Si so:" +lop.siSo);

        lop.HienThiThongTin();
    }
}
