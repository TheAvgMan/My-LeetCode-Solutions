package BacktrackingProblems.WordSearch;

import java.util.Arrays;

class Solution {
    private boolean[][] reservedElements;
    private boolean solutionFound;
    private StringBuilder wordSB;
    private char[][] board;

    boolean exist(char[][] board, String word) {
        solutionFound = false;
        wordSB = new StringBuilder(word);
        this.board = board;
        reservedElements = new boolean[this.board.length][this.board[0].length];

        for (var row : reservedElements) {
            Arrays.fill(row, false);
        }

        if (this.board.length == 1 && this.board[0].length == 1)
            return ((Character) this.board[0][0]).toString().contentEquals(wordSB);

        outer:
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (solutionFound) break outer;
                if (wordSB.charAt(0) != this.board[i][j]) continue;

                exhaustStates(i, j);
            }
        }

        return solutionFound;
    }

    private void exhaustStates(int row, int col) {

        if (wordSB.isEmpty()) {
            solutionFound = true;
            return;
        }

        if (reservedElements[row][col]) return;
        if (board[row][col] != wordSB.charAt(0)) return;

        char currentCharacter = wordSB.charAt(0);
        wordSB.deleteCharAt(0);
        reservedElements[row][col] = true;

        if (col != board[row].length - 1)
            exhaustStates(row, col + 1);

        if (row != board.length - 1)
            exhaustStates(row + 1, col);

        if (col != 0)
            exhaustStates(row, col - 1);

        if (row != 0)
            exhaustStates(row - 1, col);

        wordSB.insert(0, currentCharacter);
        reservedElements[row][col] = false;
    }
}
