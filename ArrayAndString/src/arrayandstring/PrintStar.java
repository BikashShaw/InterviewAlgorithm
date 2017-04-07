package arrayandstring;

/**
 * Print Starts in different pattern
 * Intuit Interview Question
 * Created by Bikash on 4/6/2017.
 */
public class PrintStar {

    //O(n^2)
    private static void print1(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = number; i >= 1; i--) {
            for (int j = i; j >=1 ; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private static void print2(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <=number - i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private static void print3(int number) {
        for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= number; j++) {
                    if (i == j){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
        }

        for (int j = number - 1; j >= 1; j--) {
            int k = 1;
            while (k <= j - 1) {
                System.out.print(" ");
                k++;
            }
            for (int l = 1; l <= j - k + 1; l++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        print1(5);
        print2(5);
        print3(5);
    }
}
