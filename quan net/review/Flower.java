public class Flower {
    private int petalsCount = 0;
    private String s = new String();

    Flower(int petals) {
        petalsCount = petals;
    }
    Flower(String ss) {
        s = ss;
    }
    Flower(String s, int petals){
        this(petals);
        this.s = s;
    }
    Flower() {
        this("hi", 47);
    }
    public int getPetalCount(){
        return petalsCount;
    }
    public void setPetalCount(int p) {
        petalsCount = p;
    }
}