package arrayandstring;

import java.util.Arrays;

/**
 * Find one single integer among multiple even number of integers
 * Created by Bikash on 4/4/2017.
 */
public class LonelyInteger {

    int findLonely(int a[]) {
        return Arrays.stream(a).reduce((left, right) -> left ^ right).getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new LonelyInteger().findLonely(new int[]{10, 9, 1, 2, 3, 3, 11, 2, 9, 1, 7, 7, 10}));
    }
}