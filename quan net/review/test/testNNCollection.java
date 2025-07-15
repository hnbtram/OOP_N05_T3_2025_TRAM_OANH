public class testNNCollection {
    public static void test() {
        NameNumber n1 = new NameNumber("Nguyen", "0123456789");
        NameNumber n2 = new NameNumber("Tran", "0987654321");
        NNCollection nn = new NNCollection();
        nn.insert(n1);
        nn.insert(n2);
        nn.findnumber("Nguyen");
    }
}