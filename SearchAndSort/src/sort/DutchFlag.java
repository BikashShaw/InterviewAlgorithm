package sort;
import static sort.Util.*;
/**
 * Sort an array of 0s, 1s and 2s
 Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.

 Example
 Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 * Created by Bikash on 5/8/2017.
 */
public class DutchFlag {
    public static void sort(int arr[]) {
        int low = 0 , mid = 0, high = arr.length -1;

        while (high>=mid) {
            switch (arr[mid]) {
                case 0:{
                    swapAndPrint(arr,mid,low);
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swapAndPrint(arr,mid,high);
                    high--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {2, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1,0};
        System.out.println("*BEFORE SORT**");
        print(arr);
        System.out.println("***********");
        sort(arr);

        System.out.println("*AFTER SORT**");
        print(arr);
        System.out.println("***********");
    }
}
