package search;

import java.util.Arrays;

/**
 * Various binary search operations
 * Created by Bikash on 3/26/2017.
 */
public class BinarySearch {
//    Time Complexity: O(log n)
//    Recursive Binary Search
    public int search(int a[], int low, int high, int target) {

        if(low > high) {
            return -1;
        }
        int mid = (high + low) / 2;

        if(target == a[mid]) {
            return mid;
        } else if(target < a[mid]) {
            return search(a, low, mid - 1, target);
        } else {
            return search(a, mid + 1,high, target);
        }
    }

    //Time Complexity O(logn)
    public int searchFirstOccurrence(int a[], int target) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if(target == a[mid]) {
                result = mid;
                high = mid - 1;
            }
            else if(target > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;

    }

    //Time Complexity O(logn)
    public int searchLastOccurrence(int a[], int target) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if(target == a[mid]) {
                result = mid;
                low = mid + 1;
            } else if(target > a[mid]) {
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    //Time Complexity O(logn)
    public int countOccurrence(int a[], int target) {
        return searchLastOccurrence(a, target) - searchFirstOccurrence(a,target) + 1;
    }


    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,9,10,11,12};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Array: " + Arrays.toString(a));
        System.out.println("Found 11: " + binarySearch.search(a, 0, a.length-1, 11));
        System.out.println("Found 7: " + binarySearch.search(a, 0, a.length-1, 7));
        System.out.println("Found 2: " + binarySearch.search(a, 0, a.length-1, 2));
        System.out.println("Found 12: " + binarySearch.search(a, 0, a.length-1, 12));
        System.out.println("Found 14: " + binarySearch.search(a, 0, a.length-1, 14));
        System.out.println("Found 0: " + binarySearch.search(a, 0, a.length-1, 0));
        System.out.println("Found 1: " + binarySearch.search(a, 0, a.length-1, 1));

        int b[] = {2,2,2,2,2,2,4,4,4,4,10,10,10,18,18,20,20,20,20,20};

        System.out.println("First occurrence of 10: " + binarySearch.searchFirstOccurrence(b, 10));
        System.out.println("Any occurrence of 10: " + binarySearch.search(b, 0, b.length-1, 10));
        System.out.println("Last occurrence of 10: " + binarySearch.searchLastOccurrence(b, 10));
        System.out.println("Count total occurrences of 10: " + binarySearch.countOccurrence(b, 10));

        System.out.println("First occurrence of 2: " + binarySearch.searchFirstOccurrence(b, 2));
        System.out.println("Any occurrence of 2: " + binarySearch.search(b, 0, b.length-1, 2));
        System.out.println("Last occurrence of 2: " + binarySearch.searchLastOccurrence(b, 2));
        System.out.println("Count total occurrences of 2: " + binarySearch.countOccurrence(b, 2));
    }
}
