/**
 * Created by Bikash on 3/10/2017.
 * Subtract two numbers without using arithmetic operators
 */
public class SubtractionWithoutOperator {
    public static int subtract(int a, int b) {
        return b == 0 ? a : subtract((a ^ b), (((~a) & b) << 1));
    }

    public static void main(String[] args) {
        System.out.println(subtract(100, 60));
    }
}
