package sort;

import static sort.Util.print;
import static sort.Util.swapAndPrint;

/**
 * Best O(n) and Worst O(n^2)
 * Created by Bikash on 3/20/2017.
 */
public class BubbleSort {

    public static void sort(int arr[]) {
        int n = arr.length;
        boolean swaped = false;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]){
                    swaped = true;
                    swapAndPrint(arr, j, j + 1);
                }
            }
            if (!swaped){
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 5, 3, 9, 4, 1, 7, 0};

        System.out.println("*BEFORE SORT**");
        print(arr);
        System.out.println("***********");
        sort(arr);

        System.out.println("*AFTER SORT**");
        print(arr);
        System.out.println("***********");
    }
}
