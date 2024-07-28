package SudokuSolver;

class Solution {

    void solveSudoku(char[][] board) {
        /*
            A boolean array of one element is used instead of boolean variable so that it could be passed
            by reference through the recursion layers until it hits the layer where the solution is found
            and the value of this one-element boolean array is changed from false to true.
                This technique shortens the loops when returning back to the previous recursion layers,
            because the only one solution possible has already been found.
        */
        boolean[] foundSolution = {false};
        /*
            Obviously, we start solving the 2D Sudoku Board from the first cell which is at (0,0)
        */
        exhaustStates(0, 0, board, foundSolution);
    }

    private void exhaustStates(int row, int col, char[][] board, boolean[] foundSolution) {
        /*
            If the cell we are working at contains dot character (which means empty cell) then start trying
            out all the numbers from 1 to 9 and check for each of these values if it violates the rules when
            placed in this cell.
        */
        if (board[row][col] == '.') {
            outer:
            for (int value = 1; value <= 9; value++) {
                if (foundSolution[0]) break;

                // Validating the cell value with the cell's column and row.
                for (int i = 0; i <= 8; i++) {
                    if (board[row][i] == (char) (value + 48)
                            || board[i][col] == (char) (value + 48))
                        continue outer;
                }

                int blockBeginRow = -1, blockBeginCol = -1;
                if (row < 3) blockBeginRow = 0;
                else if (row < 6) blockBeginRow = 3;
                else blockBeginRow = 6;

                if (col < 3) blockBeginCol = 0;
                else if (col < 6) blockBeginCol = 3;
                else blockBeginCol = 6;

                // Validating the cell value with the cell's block.
                for (int i = blockBeginRow; i <= blockBeginRow + 2; i++) {
                    for (int j = blockBeginCol; j <= blockBeginCol + 2; j++) {
                        if (board[i][j] == (char) (value + 48)) continue outer;
                    }
                }

                /*
                    Finally, assign the cell this value.
                        Then, if this cell was the last in the board, therefore we have found the solution.
                    But if not, then we continue solving for the remaining cells recursively.
                        And we check when coming back to a previous layer whether we found the solution or not.
                    Because if we did not find the solution, we make the cell empty again (dot character) for
                    the next iteration to be ready to do the work on the next value (1 to 9).
                */
                board[row][col] = (char) (value + 48);

                if (row == 8 && col == 8) foundSolution[0] = true;
                else if (col == 8) {
                    exhaustStates(row + 1, 0, board, foundSolution);
                    if (!foundSolution[0]) board[row][col] = '.';
                }
                else {
                    exhaustStates(row, col + 1, board, foundSolution);
                    if (!foundSolution[0]) board[row][col] = '.';
                }
            }
        }
        else {
            if (row == 8 && col == 8) foundSolution[0] = true;
            else if (col == 8) exhaustStates(row + 1, 0, board, foundSolution);
            else exhaustStates(row, col + 1, board, foundSolution);
        }
    }
}
