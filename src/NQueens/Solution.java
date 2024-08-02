package NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> solveNQueens(int n) {

        /*
           flagsOfCandidateValuesUsage is an array of length n that has a flag for each possible value
           in the problem to indicate whether this value is already used in a previous recursion level
           or not, so that the next recursion level knows that this value is not available for usage, in
           other words, reserved.
                These values talked about here are the column numbers, and they represent the indices
           in the flagsOfCandidateValuesUsage array, while the value of each index is either 0 or 1
           to indicate whether that column number (index) is free (0) or reserved / used (1).
                Of course, initially, all the columns are free of any queens, so the array is initialised
           to zero.
        */
        int[] flagsOfCandidateValuesUsage = new int[n];
        Arrays.fill(flagsOfCandidateValuesUsage, 0);

        /*
            state is the array, of size n, representing the solution at a certain stage of trial.
                It should have been 2D array, but for the fact that no 2 queens can exist in the same row
            or column, so it was reasonable to turn it into 1D array containing only the column numbers
            of each queen, while the indices are representing the row numbers.
                Initially, this array is initialised to -1.
        */
        int[] state = new int[n];
        Arrays.fill(state, -1);

        List<List<String>> solutions = new ArrayList<>();

        /*
            position is the parameter holding the value of the current index in state array that is
            worked on during the current recursive call of exhaustStates.
        */
        exhaustStates(0, n, flagsOfCandidateValuesUsage, state, solutions);

        return solutions;
    }

    private void exhaustStates(int position, int n, int[] flagsOfCandidateValuesUsage,
                        int[] state, List<List<String>> solutions) {

        if (position == n) {

            /*
               Because the state array has now filled to the end, this means a solution has been reached,
               so we should add it to the solutions array. But LeetCode wanted it in the following format,
               so we transform the current values in state array into string format then add them into
               solutions. This formatting thing made our code performance way too slower than it should be.
            */
            List<String> tempList = new ArrayList<>();
            for (var number : state) {
                tempList.add(
                        ".".repeat(number) + 'Q' + ".".repeat(n - number - 1)
                );
            }
            solutions.add(tempList);

            // We return this function call to go check out for other possible solutions.
            return;
        }

        // In this outer for loop, we loop over all the possible column numbers.
        outer:
        for (int value = 0; value < n; value++) {

            // We check if this column number is reserved / already used in a higher recursion layer or not.
            if (flagsOfCandidateValuesUsage[value] == 1) continue;

            /*
                After ensuring that this current column number is free, we check that its difference with
                any previous used column number in the state array is not the same as the difference between
                this current index / position and any previous index in the state array.

                Example:        0 3 2 1     is invalid state
                because the column number 0 is in index 0 and the column number 2 is in index 2, so this means
                that queen at (0,0) and queen at (2,2) are in the same diagonal therefore attacking each other.
            */
            for (int otherPosition = position - 1; otherPosition >= 0; otherPosition--) {
                if (((value - state[otherPosition]) == (position - otherPosition))
                        || ((state[otherPosition] - value) == (position - otherPosition)))
                    continue outer;
            }

            /*
                So finally, we assign the current index / position in the state array this column number,
                and we raise that column number's flag in the flags array as it is now reserved. Then
                we make the recursive call, to go into another recursion layer to repeat all of this.
            */
            state[position] = value;
            flagsOfCandidateValuesUsage[value] = 1;

            exhaustStates(position + 1, n, flagsOfCandidateValuesUsage, state, solutions);

            /*
                After returning from that recursion layer, we return the value of this position in
                the state array back to -1, and put the flag down of the used column number as it is
                free now.
            */
            state[position] = -1;
            flagsOfCandidateValuesUsage[value] = 0;
        }
    }
}
