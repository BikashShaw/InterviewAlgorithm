package arrayandstring.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Find Word in Matrix
 * [
 * [C, O, T, P],
 * [A, A, N, M],
 * [P, R, V, Q]
 * ]
 * word = "CAT" => True
 * word = "VAN" => True
 * word = "MAT" => False
 */

class CharacterLocation {
    char ch;
    int row;
    int col;
    int wordLocation;

    public CharacterLocation(char ch, int row, int col, int wordLocation) {
        this.ch = ch;
        this.row = row;
        this.col = col;
        this.wordLocation = wordLocation;
    }

    @Override
    public String toString() {
        return String.format("%c(%d,%d) - wl=%d", ch, row, col, wordLocation);
    }
}

public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//
//        String word = "ABCESEECFSAD";


//        char[][] board = {
//            //   0      1   2    3    4    5    6
//                {'F', 'Y', 'C', 'E', 'N', 'R', 'D'},  // 0
//                {'K', 'L', 'N', 'F', 'I', 'N', 'U'}, // 1
//                {'A', 'A', 'A', 'R', 'A', 'H', 'R'}, // 2
//                {'N', 'D', 'K', 'L', 'P', 'N', 'E'}, // 3
//                {'A', 'L', 'A', 'N', 'S', 'A', 'P'}, // 4
//                {'O', 'O', 'G', 'O', 'T', 'P', 'N'}, // 5
//                {'H', 'P', 'O', 'L', 'A', 'N', 'O'} // 6
//        };
//
//        String word = "POLAND";


        char[][] board = {
                    //    0   1   2   3
                        {'A','B','C','E'}, // 0
                        {'S','F','E','S'}, // 1
                        {'A','D','E','E'}}; // 2

        String word = "ABCESEEEFS";

        System.out.println(wordSearch.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {

        System.out.println("Searching word: " + word);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (isFound(board, r, c, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isFound(char[][] board, int row, int col, String word) {
        LinkedList<CharacterLocation> alreadyIncluded = new LinkedList<>();
        alreadyIncluded.addLast(new CharacterLocation(board[row][col], row, col, 0));

        Stack<CharacterLocation> characterLocationStack = new Stack<>();
        int wl = 1;
        while ( wl < word.length()) {
            List<CharacterLocation> adjacentCharacters = findAdjacent(board, row, col, wl, word.charAt(wl), alreadyIncluded);

            System.out.println("Adjacent Characters" + adjacentCharacters.toString());
            characterLocationStack.addAll(adjacentCharacters);
            System.out.println("Stack Characters" + characterLocationStack.toString());

            if (characterLocationStack.isEmpty() && adjacentCharacters.isEmpty()) {
                return false;
            }
            if (adjacentCharacters.isEmpty()) {
                if (!alreadyIncluded.isEmpty()) {
                    wl = characterLocationStack.peek().wordLocation + 1;
                    while (alreadyIncluded.size() > wl) {
                        System.out.println("Removing: " + alreadyIncluded.get(alreadyIncluded.size() - 1));
                        alreadyIncluded.removeLast();
                    }
                }
            } else {
                wl++;
                alreadyIncluded.add(characterLocationStack.peek());
                System.out.println("Already Included: " + alreadyIncluded.toString());
            }

            CharacterLocation characterLocation = characterLocationStack.pop();

            row = characterLocation.row;
            col = characterLocation.col;

            System.out.println("Stack Characters" + characterLocationStack.toString());
        }

        return alreadyIncluded.size() == word.length();
    }

    private List<CharacterLocation> findAdjacent(char[][] board,  int row, int col, int wl, char ch, List<CharacterLocation> alreadyIncluded) {
        System.out.println(String.format("Previous Character %c(%d,%d) Looking for character %c", board[row][col], row, col, ch));
        int rowLength = board.length;
        int colLength = board[0].length;

//        int[] rowDirections = {-1, 1, 0, 0, -1, -1, 1, 1};
//        int[] calDirections = {0, 0, -1, 1, -1, 1, -1, 1};

        int[] rowDirections = {-1, 1, 0, 0};
        int[] calDirections = {0, 0, -1, 1};

        List<CharacterLocation> characterLocations = new ArrayList<>();

        int rd = row;
        int cd = col;

        for (int d = 0; d < 4; d++) {
            rd = row + rowDirections[d];
            cd = col + calDirections[d];

            if (rd >= 0 && rd < rowLength && cd >= 0 && cd < colLength && board[rd][cd] == ch && isNotIncluded(alreadyIncluded, rd, cd)) {
                characterLocations.add(new CharacterLocation(board[rd][cd], rd, cd, wl));
            }
        }

        return characterLocations;
    }

    private boolean isNotIncluded(List<CharacterLocation> alreadyIncluded, int row, int col) {
        for (CharacterLocation characterLocation : alreadyIncluded) {
            if (characterLocation.row == row && characterLocation.col == col) {
                return false;
            }
        }

        return true;
    }
}
