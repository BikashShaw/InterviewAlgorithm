package sort;

import static sort.Util.print;
import static sort.Util.swapAndPrint;

/**
 * Created by Bikash on 3/20/2017.
 */
public class SelectionSort {

    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                swapAndPrint(arr, i, minIndex);
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
