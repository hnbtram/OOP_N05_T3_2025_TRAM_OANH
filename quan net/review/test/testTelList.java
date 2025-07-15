
import quan.net.review.model.NameNumber;
import quan.net.review.model.TelList;

public class testTelList {

    public static void test() {
        NameNumber obj1 = new NameNumber("abc", "123");
        NameNumber obj2 = new NameNumber("def", "163");
        TelList tl = new TelList();
        tl.ListOfTel(obj1);
        tl.ListOfTel(obj2);
        tl.In();
    }

    public static void main(String[] args) {
        test();
    }
}