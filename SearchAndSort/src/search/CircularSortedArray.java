package search;

import java.util.Arrays;

/**
 * Created by Bikash on 3/28/2017.
 */
public class CircularSortedArray {

    public int search(int a[], int low, int high, int target) {
        while (low <= high) {
            int mid = (high + low) / 2;
            if(target == a[mid]) { //Found target
                return mid;
            }
            if(a[mid] <= a[high]) { //right half is sorted
                if(target > a[mid] && target < a[high]) {
                    low = mid + 1; // search right sorted half
                } else {
                    high = mid - 1; // search left sorted half
                }
            } else { // left half is sorted
                if(a[low] <= target && target<a[mid]) { //left half is sorted
                    high = mid -1; // search left sorted half
                } else {
                    low = mid + 1; // search right sorted half
                }
            }

        }
        return  -1;
    }

    public static void main(String[] args) {
        int a[] = {12,14,18,21,3,8,9};
        CircularSortedArray circularSortedArray = new CircularSortedArray();

        System.out.println("Array: " + Arrays.toString(a));

        System.out.println("Found 26: " + circularSortedArray.search(a, 0, a.length-1, 26));
        System.out.println("Found 3: " + circularSortedArray.search(a, 0, a.length-1, 3));
        System.out.println("Found 21: " + circularSortedArray.search(a, 0, a.length-1, 21));
        System.out.println("Found 8: " + circularSortedArray.search(a, 0, a.length-1, 8));
        System.out.println("Found 12: " + circularSortedArray.search(a, 0, a.length-1, 12));
    }
}
