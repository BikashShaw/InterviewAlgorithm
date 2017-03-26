package search;

/**
 * Recursive Binary Search
 * Time Complexity: O(log n)
 * Created by Bikash on 3/26/2017.
 */
public class BinarySearch {

    public boolean search(int a[], int low, int high, int target) {

        if(low > high) {
            return false;
        }
        int mid = (high + low) / 2;

        if(target == a[mid]) {
            return true;
        } else if(target < a[mid]) {
            return search(a, low, mid - 1, target);
        } else {
            return search(a, mid + 1,high, target);
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,9,10,11,12};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Found 11: " + binarySearch.search(a, 0, a.length-1, 11));
        System.out.println("Found 7: " + binarySearch.search(a, 0, a.length-1, 7));
        System.out.println("Found 2: " + binarySearch.search(a, 0, a.length-1, 2));
        System.out.println("Found 12: " + binarySearch.search(a, 0, a.length-1, 12));
        System.out.println("Found 14: " + binarySearch.search(a, 0, a.length-1, 14));
        System.out.println("Found 0: " + binarySearch.search(a, 0, a.length-1, 0));
        System.out.println("Found 1: " + binarySearch.search(a, 0, a.length-1, 1));
    }
}
