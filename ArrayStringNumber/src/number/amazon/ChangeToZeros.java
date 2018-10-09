package number.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Change rows and column to zero
 * input:
 * [
 * [1,0,1,1,1]
 * [1,1,1,0,1]
 * [1,1,1,1,1]
 * ]
 * output:
 * [
 *  [0,0,0,0,0]
 *  [0,0,0,0,0]
 *  [1,0,1,0,1]
 *  ]
 */

public class ChangeToZeros {

    public static void main(String[] args) {
        int[][] area = {
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0}
        };

        ChangeToZeros changeToZeros = new ChangeToZeros();

        System.out.println("**INPUT**");
        changeToZeros.print(area);

        changeToZeros.changeToZero(area);

        System.out.println("**OUTPUT**");
        changeToZeros.print(area);
    }

    private void print(int[][] area) {
        Arrays.stream(area).map(Arrays::toString).forEach(System.out::println);
    }

    public void changeToZero(int[][] area) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        mark(area, rows, cols);
        sweep(area, rows, cols);
    }

    private void mark(int[][] area, Set<Integer> rows, Set<Integer> cols) {
        for (int r = 0; r < area.length; r++) {
            for (int c = 0; c < area[0].length; c++) {
                if(area[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }
    }

    private void sweep(int[][] area, Set<Integer> rows, Set<Integer> cols) {
        for (int r = 0; r < area.length; r++) {
            for (int c = 0; c < area[0].length; c++) {
                if (rows.contains(r) || cols.contains(c)) {
                    area[r][c] = 0;
                }
            }
        }
    }
}
