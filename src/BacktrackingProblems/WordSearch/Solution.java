package BacktrackingProblems.WordSearch;

import java.util.Arrays;

class Solution {
    boolean exist(char[][] board, String word) {
        boolean[] solutionFound = {false};

        boolean[][] reservedElements = new boolean[board.length][board[0].length];
        for (var row : reservedElements) {
            Arrays.fill(row, false);
        }

        if (board.length == 1 && board[0].length == 1)
            return ((Character) board[0][0]).toString().equals(word);

        outer:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (solutionFound[0]) break outer;
                if (word.charAt(0) != board[i][j]) continue;

                exhaustStates(solutionFound, reservedElements, i, j, board, new StringBuilder(word));
            }
        }

        return solutionFound[0];
    }

    private void exhaustStates(boolean[] solutionFound, boolean[][] reservedElements,
                               int row, int col,
                               char[][] board, StringBuilder wordSB) {

        if (wordSB.isEmpty()) {
            solutionFound[0] = true;
            return;
        }

        if (reservedElements[row][col]) return;
        if (board[row][col] != wordSB.charAt(0)) return;


        char currentCharacter = wordSB.charAt(0);
        wordSB.deleteCharAt(0);
        reservedElements[row][col] = true;

        if (col != board[row].length - 1)
            exhaustStates(solutionFound, reservedElements, row, col + 1, board, wordSB);

        if (row != board.length - 1)
            exhaustStates(solutionFound, reservedElements, row + 1, col, board, wordSB);

        if (col != 0)
            exhaustStates(solutionFound, reservedElements, row, col - 1, board, wordSB);

        if (row != 0)
            exhaustStates(solutionFound, reservedElements, row - 1, col, board, wordSB);

        wordSB.insert(0, currentCharacter);
        reservedElements[row][col] = false;
    }
}
