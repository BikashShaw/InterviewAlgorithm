package arrayandstring.matrix;

import java.util.ArrayList;
import java.util.List;

public class Icelands {


    List<Integer[][]> allIceLands(int[][] area) {
        boolean[][] visited = new boolean[area.length][area[0].length];
        List<Integer[][]> icelands = new ArrayList<>();
        int i = 0;
        int j = 0;

        int n = area.length;
        int m = area[0].length;
        int[] fc = {-1, -1};
        int[] lc = {-1, -1};

        while (i < n && j < m) {
            if (area[i][j] == 0 && (i - 1 >= 0 && area[i - 1][j] == 0 && visited[i - 1][j])) {
                visited[i][j] = true;
                j++;
            } else if (area[i][j] == 0 && !visited[i][j] && fc[0] == -1) {
                fc[0] = i;
                fc[1] = j;
                lc[0] = i;
                lc[1] = j;
                visited[i][j] = true;

                j++;
            } else if (area[i][j] == 0 && !visited[i][j] && fc[0] > -1) {
                lc[0] = i;
                lc[1] = j;
                visited[i][j] = true;
                j++;
            } else if (area[i][j] == 1 && fc[0] > -1 && (j - 1 >= 0 && visited[i][j - 1])) {
                i++;
                j--;
                if (i >= area.length) {
                    icelands.add(new Integer[][]{{fc[0], fc[1]}, {lc[0], lc[1]}});
                    i = 0;
                    j = 0;
                    reset(fc, lc);
                }
            } else if (area[i][j] == 1 && fc[0] > -1 && (i - 1 >= 0 && visited[i - 1][j])) {
                visited[i][j] = true;
                icelands.add(new Integer[][]{{fc[0], fc[1]}, {lc[0], lc[1]}});
                i = 0;
                j = 0;
                reset(fc, lc);
            } else {
                j++;
                if (j >= area[0].length) {
                    j = 0;
                    i++;
                }
            }
        }
        return icelands;
    }

    private void reset(int[] fc, int[] lc) {
        fc[0] = -1;
        fc[1] = -1;

        lc[0] = -1;
        lc[1] = -1;
    }

    public static void main(String[] args) {
        int[][] area = {
                //  0  1  2  3  4  5
                {1, 1, 1, 1, 1, 1}, // 0
                {1, 0, 1, 1, 1, 1}, // 1
                {1, 0, 1, 0, 0, 1}, // 2
                {1, 0, 1, 0, 0, 1}, // 3
                {0, 1, 0, 1, 1, 1}, // 4
                {0, 1, 1, 1, 0, 1}, // 5
                {0, 1, 1, 1, 1, 1}, // 6
                {1, 0, 0, 0, 0, 1}, // 7
                {1, 0, 0, 0, 0, 1}}; // 8

        new Icelands().allIceLands(area);
    }
}
