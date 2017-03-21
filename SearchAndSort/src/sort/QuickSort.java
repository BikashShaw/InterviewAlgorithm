package sort;


import static sort.Util.print;
import static sort.Util.swapAndPrint;

/**
 * Created by Bikash on 3/21/2017.
 */
public class QuickSort {

    public static void sort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr,low, partition - 1);
            quickSort(arr,partition + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = high;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] < arr[pivot]) {
                i++;
                swapAndPrint(arr,i, j);
            }
        }
        i++;
        swapAndPrint(arr,i, pivot);
        return i;
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
