package sort;

import static sort.Util.print;

/**
 * Created by Bikash on 3/21/2017.
 */
public class MergeSort {
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length -1);
    }

    public static void mergeSort(int[] arr,  int left, int right) {

        if(left < right) {
            int mid = (left + right) /2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1,right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int leftCount = mid - left + 1;
        int rightCount = right - mid;

        //Create and Copy subarray
        int leftArr[] = new int[leftCount];
        for (int i = 0; i < leftCount; i++) {
            leftArr[i] = arr[left + i];
        }
        int rightArr[] = new int[rightCount];
        for (int j = 0; j < rightCount; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;

        while (i<leftCount && j<rightCount) {
            if(leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
            print(arr);
        }

        //Copy remaining elements
        while (i < leftCount) {
            arr[k++] = leftArr[i++];
            print(arr);
        }
        while (j < rightCount) {
            arr[k++] = rightArr[j++];
            print(arr);
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
