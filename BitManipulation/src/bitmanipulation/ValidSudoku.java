package bitmanipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode: https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] validSudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] inValidSudoku = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        output(validSudoku);

        output(inValidSudoku);
    }

    private static void output(char[][] sudoku) {
        for (char[] chars : sudoku) {
            System.out.println(Arrays.toString(chars));
        }

        System.out.println("Is valid: " + isValidSudokuBitManipulation(sudoku));
    }

    public static boolean isValidSudokuEasy(char[][] sudoku) {
        Set<String> set = new HashSet<>();

        int rowLength = sudoku.length;
        int colLength = sudoku[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (sudoku[row][col] != '.') {
                    if (!set.add(String.format("%c in row %d", sudoku[row][col], row))
                            || !set.add(String.format("%c in col %d", sudoku[row][col], col))
                            || !set.add(String.format("%c in block %d", sudoku[row][col], 3 * (row / 3) + (col / 3)))) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    public static boolean isValidSudokuBitManipulation(char[][] sudoku) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] square = new short[9];

        int rowLength = sudoku.length;
        int colLength = sudoku[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (sudoku[row][col] == '.') {
                    continue;
                }
                short value = (short) (1 << (sudoku[row][col] - '1'));

                if ((rows[row] & value) > 1) {
                    return false;
                }

                if ((cols[col] & value) > 1) {
                    return false;
                }

                int squareIndex = 3 * (row / 3) + (col / 3);

                if ((square[squareIndex] & value) > 1) {
                    return false;
                }

                rows[row] |= value;
                cols[col] |= value;
                square[squareIndex] |= value;
            }
        }
        return true;
    }
}
