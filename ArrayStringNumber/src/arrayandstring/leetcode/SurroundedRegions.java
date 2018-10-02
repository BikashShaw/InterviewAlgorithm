package arrayandstring.leetcode;

import java.util.Arrays;

/**
 * Leetcode: https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    int rows;
    int cols;

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'O'},
                {'O', 'O', 'X', 'O'}};

        print(board);

        new SurroundedRegions().solve(board);

        System.out.println("**AFTER**");
        print(board);
    }

    private static void print(char[][] board) {
        for (char[] rows : board) {
            System.out.println(Arrays.toString(rows));
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        rows = board.length;
        cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean[][] visited = new boolean[rows][cols];
                if (board[r][c] == 'O' && !isConnectedToBoarder(board, r, c, visited)) {
                    changeValue(board, r, c);
                }
            }
        }
    }

    private boolean isConnectedToBoarder(char[][] board, int r, int c, boolean[][] visited) {
        if (visited[r][c]) {
            return false;
        } else if (r == 0 && board[r][c] == 'O') {
            return true;
        } else if (r == rows - 1 && board[r][c] == 'O') {
            return true;
        } else if (c == 0 && board[r][c] == 'O') {
            return true;
        } else if (c == cols - 1 && board[r][c] == 'O') {
            return true;
        } else if (r == 0 && board[r][c] == 'X') {
            return false;
        } else if (r == rows - 1 && board[r][c] == 'X') {
            return false;
        } else if (c == 0 && board[r][c] == 'X') {
            return false;
        } else if (c == cols - 1 && board[r][c] == 'X') {
            return false;
        } else if (r > rows - 1 || c > cols - 1 || board[r][c] == 'X') {
            return false;
        }

        visited[r][c] = true;

        return isConnectedToBoarder(board, r - 1, c, visited)
                || isConnectedToBoarder(board, r + 1, c, visited)
                || isConnectedToBoarder(board, r, c - 1, visited)
                || isConnectedToBoarder(board, r, c + 1, visited);
    }

    private void changeValue(char[][] board, int r, int c) {
        if (r < 0 || r > rows - 1 || c < 0 || c > cols - 1 || board[r][c] == 'X') {
            return;
        }

        board[r][c] = 'X';

        changeValue(board, r - 1, c);

        changeValue(board, r + 1, c);

        changeValue(board, r, c - 1);

        changeValue(board, r, c + 1);

    }
}
