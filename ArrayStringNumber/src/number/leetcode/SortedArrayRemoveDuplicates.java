package number.leetcode;

import java.util.Arrays;

public class SortedArrayRemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int currentNumber = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > currentNumber) {
                    currentNumber = nums[j];
                    int temp = nums[i];
                    nums[counter] = nums[j];
                    nums[j] = temp;
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public int removeDuplicates2(int[] nums) {
        int index = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};
//        int[] nums = {0, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(new SortedArrayRemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
