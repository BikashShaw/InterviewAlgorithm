package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Description: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class SortedMatrixKSmallestElement {

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;

        System.out.println(new SortedMatrixKSmallestElement().kthSmallest(matrix1, k));

        int[][] matrix2 = {
                {1}
        };

        System.out.println(new SortedMatrixKSmallestElement().kthSmallest(null, 1));

        System.out.println(new SortedMatrixKSmallestElement().kthSmallest(matrix2, 1));
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int[] rows : matrix) {
            for (int e : rows) {
                if (maxHeap.size() >= k) {
                    if (maxHeap.peek() > e) {
                        maxHeap.poll();
                        maxHeap.offer(e);
                    }
                } else {
                    maxHeap.offer(e);
                }
            }
        }

        return maxHeap.peek();
    }
}
