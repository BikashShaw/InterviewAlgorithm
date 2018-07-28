package arrayandstring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        int inc = 1;

        while (inc <= nums.length) {
            powerSet.addAll(iter(nums, inc));
            inc++;
        }

        return powerSet;
    }

    private List<List<Integer>> iter(int[] nums, int inc) {
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < i + inc; j++) {
                if (j < nums.length) {
                    subSet.add(nums[j]);
                }
            }
            if (subSet.size() == inc) {
                powerSet.add(subSet);
            }
            subSet = new ArrayList<>();
        }
        return powerSet;
    }


}
