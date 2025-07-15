package quan.net.review.model;
import java.util.ArrayList;

public class TelList {
    public ArrayList<NameNumber> tl = new ArrayList<NameNumber>();

    // Thêm một NameNumber vào danh sách
    public void ListOfTel(NameNumber n) {
        tl.add(n);
    }

    public void In() {
        for (int i = 0; i < tl.size(); i++) {
            System.out.println("ten: " + tl.get(i).getName());
        }
    }
}