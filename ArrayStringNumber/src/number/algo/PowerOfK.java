package number.algo;

/**
 * Given an integer, write a function to determine if it is a power of K
 * Created by Bikash on 4/26/2017.
 */
public class PowerOfK {
    public boolean isPowerOfK(int n, int k) {
        return n > 0 &&  (Math.log10(n) / Math.log10(k)) % 1 == 0;
    }

    public static void main(String[] args) {
        PowerOfK powerOfThree = new PowerOfK();
        System.out.println("27 power of 3: " + powerOfThree.isPowerOfK(27,3));
        System.out.println("45 power of 3: " + powerOfThree.isPowerOfK(45, 3));

        System.out.println("32 power of 2: " + powerOfThree.isPowerOfK(32,2));
        System.out.println("45 power of 2: " + powerOfThree.isPowerOfK(45, 2));
    }
}
