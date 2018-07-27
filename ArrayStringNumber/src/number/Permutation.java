package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        List<List<Integer>> permutation = new Permutation().permute(a);
        permutation.forEach(result -> System.out.println(result.toString()));
    }

    private List<List<Integer>> permute(int[] a) {
        List<List<Integer>> results = new ArrayList<>();

        Integer[] num = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            num[i] = a[i];
        }

        permute(num, 0, results);

        return results;
    }

    private void permute(Integer[] a, int start, List<List<Integer>> results) {
        if (start >= a.length) {
            results.add(Arrays.asList(a));
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i);
                permute(a, start + 1, results);
                swap(a, start, i);
            }
        }
    }

    private void swap(Integer[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
