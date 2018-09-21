package arrayandstring.matrix;

public class Islands {


    private int nc;
    private int nr;

    public int numIslands(int[][] grid) {


        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0 ;

        nc = grid.length;
        nr = grid[0].length;

        for(int i = 0; i < nc; i++) {
            for(int j = 0; j < nr; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    changeToWater(grid, i , j);
                }
            }
        }

        return count;
    }

    private void changeToWater(int[][] grid, int i, int j) {
        if(i < 0  || i >= nc || j < 0 || j >= nr || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        changeToWater(grid, i - 1, j);
        changeToWater(grid, i + 1, j);
        changeToWater(grid, i , j - 1);
        changeToWater(grid, i , j + 1);
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

        System.out.println(new Islands().numIslands(area));

    }
}
