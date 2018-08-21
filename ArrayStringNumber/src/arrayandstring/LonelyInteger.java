package arrayandstring;

import java.util.Arrays;

/**
 * Find one single integer among multiple even number of integers
 * Created by Bikash on 4/4/2017.
 */
public class LonelyInteger {

    int findLonely(int a[]) {
        return Arrays.stream(a).reduce((left, right) -> left ^ right).orElse(-1);
    }

    /**
     * Given a sorted array consisting of only integers where every
     * element appears twice except for one element which appears once.
     * Find this single element that appears only once.
     * <br />
     * <strong>Note:</strong> Your solution should run in O(log n) time and O(1) space.
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {

        System.out.println(Arrays.toString(nums));

        int low = 0, high = nums.length / 2;

        while (low < high) {
            int mid = (low + high) / 2;
            System.out.println("Low: " + low + " Mid: " + mid + " High: " + high);
            System.out.println("nums[2*mid]: " + nums[2 * mid]);
            System.out.println("nums[2*mid+1]: " + nums[2 * mid + 1]);
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                high = mid;
                System.out.println("High : " + high);
            } else {
                low = mid + 1;
                System.out.println("Low : " + low);
            }
        }
        return nums[2 * low];
    }

    public static void main(String[] args) {
        LonelyInteger lonelyInteger = new LonelyInteger();
        System.out.println(lonelyInteger.findLonely(new int[]{10, 9, 1, 2, 3, 3, 11, 2, 9, 1, 7, 7, 10}));
        System.out.println(lonelyInteger.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));
    }
}
