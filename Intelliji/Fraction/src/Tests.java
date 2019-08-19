import java.util.Random;

public class Tests {
    public static void main(String[] args) {

        Fraction fr = new Fraction();
        Random rn = new Random();

        long start = System.currentTimeMillis();
        for (int i = 0; i <1000 ; i++) {
           fr.setNumber(rn.nextDouble());
            System.out.println(fr.getFraction());
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+" mil. sec.");



    }
}
