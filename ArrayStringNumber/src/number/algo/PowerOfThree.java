package number.algo;

/**
 * Created by Bikash on 4/26/2017.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 &&  (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println("27: " + powerOfThree.isPowerOfThree(27));
        System.out.println("45: " + powerOfThree.isPowerOfThree(45));
    }
}
