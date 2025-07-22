public class testTune {
    public static void test() {
        Cellphone noiseMaker = new Cellphone();
        Tune t1 = new Tune();
        Tune t2 = new ObnoxiousTune();
        
        noiseMaker.ring(t1);
        noiseMaker.ring((Tune)t2);

    }
}
