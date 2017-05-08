package number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bikash Shaw on 4/28/2017. <br />
 * <strong>URL:</strong> https://www.hackerrank.com/challenges/a-very-big-sum
 */
public class BigSum {

    public static String sum(int nums[]) {
        List<String> collect = Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.toList());
        collect.sort((a, b) -> b.length() - a.length());
        int longestNumber = collect.get(0).length();

        collect = collect.stream().map(a -> {
            return insertLeadingZeros(a, longestNumber);
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

        int carry = 0;
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < longestNumber; i++) {
            Integer stepSum = 0;
            for (String s : collect) {
                char c = s.charAt(longestNumber - i - 1);;
                Integer integer = Integer.valueOf(c+"");
                stepSum+=integer;
            }
            stepSum+=carry;
            carry = stepSum /10;
            stepSum =  stepSum % 10;
            sum.insert(0,stepSum);
        }
        if(carry > 0){
            sum.insert(0,carry);
        }
        return sum.toString();
    }

    private static String insertLeadingZeros(String a, int longestNumber) {
        StringBuilder stringBuilder = new StringBuilder(a);
        int initialLen = a.length();
        for (int i = 0; i < longestNumber - initialLen; i++) {
            stringBuilder.insert(0,"0");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int nums[] = {1001458909,1004570889,1007019111, 1003302837, 1002514638, 1006431461, 1002575010, 1007514041, 1007548981, 1004402249};
        System.out.println("Sum of " + Arrays.toString(nums) + " is " + sum(nums));
        nums = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        System.out.println("Sum of " + Arrays.toString(nums) + " is " + sum(nums));
    }
}
