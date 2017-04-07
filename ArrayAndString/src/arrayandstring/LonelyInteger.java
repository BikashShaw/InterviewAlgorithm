package arrayandstring;

/**
 * Find one single integer among multiple even number of integers
 * Created by Bikash on 4/4/2017.
 */
public class LonelyInteger {

    int findLonely(int a[]) {
        int result = 0;
        for (int i : a) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LonelyInteger().findLonely(new int[] {9, 1, 2, 3, 2, 9, 1, 7, 7}));
    }
}
