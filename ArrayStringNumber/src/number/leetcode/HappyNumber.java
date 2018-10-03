package number.leetcode;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println("Happy Number 19: " + happyNumber.isHappy(19));

        System.out.println("Happy Number 27: " + happyNumber.isHappy(27));

        System.out.println("Happy Number 7: " + happyNumber.isHappy(7));

        System.out.println("Happy Number BIG: " + happyNumber.isHappy(1111111)); // WRONG

    }

    public boolean isHappy(int n) {
        int[] sqars = new int[10];

        int sum = n > 9 ? n : n * n;

        while (sum > 9) {
            n = sum;
            sum = 0;
            while (n >= 1) {
                int mod = n % 10;
                n = n / 10;
                int sqar;
                if (sqars[mod] == 0) {
                    sqars[mod] = mod * mod;
                }
                sqar = sqars[mod];
                sum += sqar;

            }
        }

        return sum == 1;
    }
}
