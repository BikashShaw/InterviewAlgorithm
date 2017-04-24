package arrayandstring;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Leetcode: Remove array elements in-place
 * Created by Bikash on 4/24/2017.
 */
public class ArrayRemoveElement {
    public static int removeElement(int[] nums, int removeElement) {
        int[] filtered = Arrays.stream(nums).filter(v -> v != removeElement).toArray();
        IntStream.range(0, filtered.length).parallel().forEach(i -> nums[i] = filtered[i]);

        return filtered.length;
    }

    public static void main(String[] args) {
        int removeElement = 3;
        int[] nums = {3, 1, 2, 3, 3};

        IntStream.range(0, removeElement(nums, removeElement)).parallel().forEach(i -> System.out.println(nums[i]));
    }
}
