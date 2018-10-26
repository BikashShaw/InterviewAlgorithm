package search;

import java.util.Arrays;

/**
 * Leetcode: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Created by Bikash on 3/28/2017.
 */
public class CircularSortedArray {

    public int search(int nums[], final int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (target == nums[mid]) { //Found target
                return mid;
            }
            if (nums[mid] <= nums[high]) { //right half is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // search right sorted half
                } else {
                    high = mid - 1; // search left sorted half
                }
            } else { // left half is sorted
                if (nums[low] <= target && target <= nums[mid]) { //left half is sorted
                    high = mid - 1; // search left sorted half
                } else {
                    low = mid + 1; // search right sorted half
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {12, 14, 18, 21, 3, 8, 9};
        CircularSortedArray circularSortedArray = new CircularSortedArray();

        System.out.println("Array: " + Arrays.toString(a));

        System.out.println("Found 26: " + circularSortedArray.search(a, 26));
        System.out.println("Found 3: " + circularSortedArray.search(a, 3));
        System.out.println("Found 21: " + circularSortedArray.search(a, 21));
        System.out.println("Found 8: " + circularSortedArray.search(a, 8));
        System.out.println("Found 12: " + circularSortedArray.search(a, 12));
    }
}
