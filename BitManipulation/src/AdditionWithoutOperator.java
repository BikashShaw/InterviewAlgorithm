/**
 * Created by Bikash on 3/10/2017.
 * Add two numbers without using arithmetic operators
 */
public class AdditionWithoutOperator {

    public static int add(int a, int b) {
        return b == 0 ? a : add((a ^ b), ((a & b) << 1));
    }

    public static void main(String[] args) {
        System.out.println(add(99,111));
    }

}
