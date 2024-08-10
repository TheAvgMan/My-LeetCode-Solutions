package BacktrackingProblems.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> solutions;
    private StringBuilder parenthesisSB;
    private int n;

    List<String> generateParenthesis(int n) {
        solutions = new ArrayList<>();
        parenthesisSB = new StringBuilder("(");
        this.n = n;

        /*
            This function starts with one opening bracket and then traverses over a binary tree until
            all the possible valid formations of the n pairs of parenthesis are added to the solutions
            list.
        */
        exhaustStates(1, 0);

        return solutions;
    }

    private void exhaustStates(int openingBracketCounter, int closingBracketCounter) {

        if (closingBracketCounter == n) {
            solutions.add(parenthesisSB.toString());
            return;
        }

        /*
            The binary tree looks like the following:

                                (
                               /  \
                              (    )
                             / \  / \
                            (   ) (  )
                       and so on ........

            So, by default, we keep traversing left as long as the number of traversed opening brackets is
            still less than n (the number of pairs).
                Once it's equal to n, we start traversing right, where the closing brackets are. We only keep
            traversing right until the number of closing brackets matches the number of opening brackets.
                Once that happens, we have got a solution to add to the solutions list. Then all of these
            recursive calls keep returning up until they reach the level where they can repeat all of this
            again.
                This keeps happening until the root node is reached at the end and the first call ever finally
            returns.
        */

        if (openingBracketCounter < n) {
            parenthesisSB.append('(');
            exhaustStates(openingBracketCounter + 1, closingBracketCounter);
            parenthesisSB.deleteCharAt(parenthesisSB.length() - 1);
        }

        if (closingBracketCounter < openingBracketCounter) {
            parenthesisSB.append(')');
            exhaustStates(openingBracketCounter, closingBracketCounter + 1);
            parenthesisSB.deleteCharAt(parenthesisSB.length() - 1);
        }
    }
}
