package arrayandstring.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <br /><strong>URL:</strong> https://leetcode.com/problems/spiral-matrix/description/
 * <br /><strong>Example 1:</strong><br />
 * Input:
 * [<br />
 * [ 1, 2, 3 ],<br />
 * [ 4, 5, 6 ],<br />
 * [ 7, 8, 9 ]<br />
 * ] <br />
 * Output: [1,2,3,6,9,8,7,4,5]<br />
 * <br /><strong>Example 2:</strong><br />
 * Input:
 * [<br />
 * [1, 2, 3, 4],<br />
 * [5, 6, 7, 8],<br />
 * [9,10,11,12]<br />
 * ] <br />
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]<br />
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(spiralMatrix.spiralOrder(matrix1));

        System.out.println(spiralMatrix.spiralOrder(matrix2));

        System.out.println(spiralMatrix.spiralOrder(matrix3));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length < 1) {
            return new ArrayList<>();
        }

        final int DIRECTION_LEFT = 0;
        final int DIRECTION_BOTTOM = 1;
        final int DIRECTION_RIGHT = 2;
        final int DIRECTION_UP = 3;

        int currentDirection = DIRECTION_LEFT;

        int rows = matrix.length; //3
        int cols = matrix[0].length; // 4
        int maxPossibleSteps = rows * cols;
        List<Integer> output = new ArrayList<>();
        boolean visited[][] = new boolean[rows][cols];

        int r = 0;
        int c = 0;
        while (output.size() < maxPossibleSteps) {
            if (!visited[r][c]) {
                output.add(matrix[r][c]);
                visited[r][c] = true;
            }
            if(currentDirection == DIRECTION_LEFT) {
                if (c < cols - 1 && !visited[r][c + 1]) { //Move Left
                    c++; // 1 2 3
                } else if (r < rows - 1 && !visited[r + 1][c]) { //Move Bottom
                    r++;
                    currentDirection = DIRECTION_BOTTOM;
                }
            } else if (currentDirection == DIRECTION_BOTTOM) {
                if (r < rows - 1 && !visited[r + 1][c]) { //Move Bottom
                    r++;
                }  else if (c > 0 && !visited[r][c - 1]) { //Move Right
                    c--;
                    currentDirection = DIRECTION_RIGHT;
                }
            } else if (currentDirection == DIRECTION_RIGHT) {
                if (c > 0 && !visited[r][c - 1]) { //Move Right
                    c--;
                } else if (r > 0 && !visited[r - 1][c]) { //Move Up
                    r--;
                    currentDirection = DIRECTION_UP;
                }
            } else if (currentDirection == DIRECTION_UP) {
                if (r > 0 && !visited[r - 1][c]) { //Move Up
                    r--;
                } else if (c < cols - 1 && !visited[r][c + 1]) { //Move Left
                    c++; // 1 2 3
                    currentDirection = DIRECTION_LEFT;
                }
            }
        }

        return output;
    }
}
