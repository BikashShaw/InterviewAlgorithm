package number.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        pascalsTriangle.print(pascalsTriangle.generate(0));
    }

    private void print(List<List<Integer>> pascalsTriangle) {
        for (List<Integer> layer : pascalsTriangle) {
            System.out.println(layer.toString());
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int size = 1; size <= numRows; size++) {
            List<Integer> list = new ArrayList<>(size);

            list.add(1);
            if(size > 1) {
                makeNextInvertedPyramid(triangle.get((size - 1) - 1), list, size);
            }

            triangle.add(list);
        }
        return triangle;
    }

    private void makeNextInvertedPyramid(List<Integer> upperLayer, List<Integer> currentLayer, int totalSize) {
        for (int i = 1; i < totalSize; i++) {
            if(i == totalSize - 1) {
                currentLayer.add(1);
            } else if (upperLayer.size() >= 2) {
                currentLayer.add(upperLayer.get(i - 1) + upperLayer.get(i));
            }
        }
    }
}
