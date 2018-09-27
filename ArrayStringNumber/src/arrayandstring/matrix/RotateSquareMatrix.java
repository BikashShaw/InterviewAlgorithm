package arrayandstring.matrix;

/**
 * Matrix rotation by left or right 90
 * Created by Bikash on 3/26/2017.
 */
public class RotateSquareMatrix {

    public enum Rotation {
        RIGHT, LEFT
    }

    private int[][] rotate(int matrix[][], Rotation rotation) {
        int transposed[][] = new int [matrix.length][matrix.length];
        int n = matrix.length - 1;
        int newRow, newCol;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                //Right rotation r1=n-c & c1=r
                if (rotation.equals(Rotation.RIGHT)) {
                    newRow = n - col;
                    newCol = row;
                } else { //Right rotation r1=c & c1=n-r
                    newRow = col;
                    newCol = n - row;
                }
                transposed[newRow][newCol] = matrix[row][col];
            }
        }
        return transposed;
    }

    public static void printMatrix(int matrix[][]) {
        for (int[] rows : matrix) {
            for (int value : rows) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};

        RotateSquareMatrix rotateSquareMatrix = new RotateSquareMatrix();
        System.out.println("**MATRIX**");
        RotateSquareMatrix.printMatrix(matrix);
        System.out.println("**Rotate Left**");
        RotateSquareMatrix.printMatrix(rotateSquareMatrix.rotate(matrix, Rotation.LEFT));
        System.out.println("**Rotate Right**");
        RotateSquareMatrix.printMatrix(rotateSquareMatrix.rotate(matrix, Rotation.RIGHT));
    }
}


