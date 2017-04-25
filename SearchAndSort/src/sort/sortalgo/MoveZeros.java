package sort.sortalgo;

import static sort.Util.print;
import static sort.Util.swapAndPrint;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 * Created by Bikash on 4/25/2017.
 */
public class MoveZeros {

    //Like bubble sort
    private static void moveZero(int[] nums) {
        int n = nums.length;
        boolean swaped = false;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (nums[j] == 0){
                    swaped = true;
                    swapAndPrint(nums, j, j + 1);
                }
            }
            if (!swaped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 0, -5, 0, 9, 4, 1, 7, 8};

        System.out.println("*BEFORE MOVE**");
        print(arr);
        System.out.println("***********");
        moveZero(arr);

        System.out.println("*AFTER MOVE**");
        print(arr);
        System.out.println("***********");
    }


}
