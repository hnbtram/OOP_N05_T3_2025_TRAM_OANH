import quan.net.review.model.Leaf;

public class testLeaf {
    public static void test() {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }

    public static void main(String[] args) {
        test();
    }
}
