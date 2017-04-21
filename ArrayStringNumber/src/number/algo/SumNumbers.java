package number.algo;

/**
 * Sum of all positive numbers
 * Asked in Oracle interview
 * Created by Bikash on 4/21/2017.
 */
public class SumNumbers {
    private int sum(int num) {
        if(num == 0) {
            return 0;
        } else if(num < 0) {
            throw new IllegalArgumentException("Must provide positive number.");
        }
        return num %10 + sum(num /10);
    }

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println("Sum 1234: " + sumNumbers.sum(1234));
        System.out.println("Sum 1000000: " + sumNumbers.sum(1000000));
        System.out.println("Sum 12345: " + sumNumbers.sum(12345));

    }
}
