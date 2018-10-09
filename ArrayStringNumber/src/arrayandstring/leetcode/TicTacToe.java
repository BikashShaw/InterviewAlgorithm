package arrayandstring.leetcode;

public class TicTacToe {

    private int length;

    private int[] rowsCounter;
    private int[] colsCounter;
    private int diagonalLeft;
    private int diagonalRight;

    public TicTacToe(int n) {
        this.length = n;
        this.rowsCounter = new int[this.length];
        this.colsCounter = new int[this.length];
        this.diagonalLeft = 0;
        this.diagonalRight = 0;
    }

    public int move(int row, int col, int player) {
        int move = player == 1 ? 1 : -1;

        this.rowsCounter[row] += move;

        this.colsCounter[col] += move;

        if (row == col) {
            this.diagonalLeft += move;
        }

        if (row == this.length - col - 1) {
            this.diagonalRight += move;
        }

        if (this.rowsCounter[row] == this.length || this.colsCounter[row] == this.length
                || this.diagonalLeft == this.length || this.diagonalRight == this.length) {
            return 1;
        } else if (this.rowsCounter[row] == -this.length || this.colsCounter[row] == -this.length
                || this.diagonalLeft == -this.length || this.diagonalRight == -this.length) {
            return 2;
        } else {
            return 0;
        }
    }
}
