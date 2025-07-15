package quan.net.review.model;
public class NNCollection {
    private NameNumber[] nnArray = new NameNumber[100];
    private int free;

    public NNCollection() {
        free = 0;
    }

    // Phương thức chèn NameNumber vào mảng theo thứ tự tên
    public void insert(NameNumber n) {
        int i = free;
        while (i > 0 && nnArray[i - 1].getName().compareTo(n.getName()) > 0) {
            nnArray[i] = nnArray[i - 1];
            i--;
        }
        nnArray[i] = n;
        free++;
    }

    public String findNumber(String lName) {
        for (int i = 0; i < free; i++) {
            if (nnArray[i].getName().equals(lName)) {
                return nnArray[i].getNumber();
            }
        }
        return "Name not found";
    }

    public void print() {
        System.out.println("Size: " + free);
        for (int i = 0; i < free; i++) {
            System.out.println("Name: " + nnArray[i].getName() + ", Number: " + nnArray[i].getNumber());
        }
    }

    public static void main(String[] args) {
        NNCollection collection = new NNCollection();
        collection.insert(new NameNumber("Alice", "123456789"));
        collection.insert(new NameNumber("Bob", "987654321"));
        collection.print();
        System.out.println(collection.findNumber("Alice"));
        System.out.println(collection.findNumber("Charlie"));
    }
}