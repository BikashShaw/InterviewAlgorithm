package sortingproblems;

import java.util.Arrays;

/**
 * Time Complexity O(n)
 * Created by Bikash on 3/24/2017.
 */
public class MergeSortedArray {

    public int[] marge(int a[], int b[], int m, int n) {
        int i = m  - 1; // last index of a
        int j = n - 1; // last index of b
        int k = m + n -1; // last index of a+b

        //loop still last index of a+b to 0
        while (k >= 0) {
            //b's index < 0(no more recodes in second array) or a's index > 0 and a's value greater than b's value
            if(j < 0 || (i >=0 && a[i] > b[j])) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int m = 3, n = 5;
        int a[] = new int[m + n];
        int b[] = new int[n];

        a[0] = 5;
        a[1] = 7;
        a[2] = 9;

        b[0] = 1;
        b[1] = 2;
        b[2] = 6;
        b[3] = 8;
        b[4] = 10;

        a = new  MergeSortedArray().marge(a,b,m,n);

        System.out.println(Arrays.toString(a));
    }
}
