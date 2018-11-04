package arrayandstring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2, 3, 4};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();

        outputList.add(new ArrayList<>());
        for (int elementCount = 1; elementCount < nums.length; elementCount++) {
            int position = 0;
            while (position < nums.length) {
                subList(elementCount, position, outputList, nums);
                System.out.println(outputList);
                position++;
            }
        }
        return outputList;
    }

    private void subList(int elementCount, int position, List<List<Integer>> outputList, int[] nums) {
        List<List<Integer>> subLists = new ArrayList<>();
        for (int i = 0; i < outputList.size(); i++) {
            List<Integer> list = outputList.get(i);
            if (list.size() == elementCount - 1 && i <= position) {
                List<Integer> subList = new ArrayList<>(list);
                subList.add(nums[position]);
                subLists.add(subList);
            }
        }

        outputList.addAll(subLists);
    }

}
