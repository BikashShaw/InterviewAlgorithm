package arrayandstring.leetcode;

import arrayandstring.matrix.RotateSquareMatrix;

public class RotateImage {
    public void rotateClockwise(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows / 2; r++) {
            for (int c = r; c < cols - r - 1; c++) {
                // swapping
                int temp = matrix[r][c];

                matrix[r][c] = matrix[rows - c - 1][r];
                matrix[rows - c - 1][r] = matrix[rows - r - 1][cols - c - 1];
                matrix[rows - r - 1][cols - c - 1] = matrix[c][cols - r - 1];
                matrix[c][cols - r - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("**MATRIX**");
        RotateSquareMatrix.printMatrix(matrix);
        System.out.println("**Rotate 90 clockwise**");
        new RotateImage().rotateClockwise(matrix);
        RotateSquareMatrix.printMatrix(matrix);
    }


}
