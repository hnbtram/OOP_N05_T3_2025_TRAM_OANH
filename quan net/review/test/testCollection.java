

import quan.net.review.model.NameNumber;
import quan.net.review.model.NNCollection;

public class testCollection {
    public static void test() {
        NameNumber obj1 = new NameNumber("abc", "123");
        NameNumber obj2 = new NameNumber("def", "163");
        NNCollection nn = new NNCollection();
        nn.insert(obj1);
        nn.insert(obj2);

        nn.print();

        // nn.findNumber("fffll");
    }

    public static void main(String[] args) {
        test();
    }
}