package arrayandstring.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Leetcode: https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {


    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {3, 310, 350, 500, 900};
        System.out.println(largestNumber.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }

        String[] strArray = new String[nums.length];
        int index = 0;
        for (int num : nums) {
            strArray[index] = num + "";
            index++;
        }

        Arrays.sort(strArray, (str1, str2) -> Long.valueOf(str1 + str2).compareTo(Long.valueOf(str2 + str1)) * -1 );

        System.out.println(Arrays.toString(strArray));

        StringBuilder builder = new StringBuilder();
        for (String s : strArray) {
            builder.append(s);
        }

        return new BigInteger(builder.toString()).toString();
    }

}
