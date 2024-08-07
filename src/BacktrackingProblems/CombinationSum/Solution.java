package BacktrackingProblems.CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();

        exhaustStates(new ArrayList<>(), 0, 0, solutions, candidates, target);

        return solutions;
    }

    private void exhaustStates(List<Integer> currentList, int currentSum,
                               int startCandidatesIndex,
                               List<List<Integer>> solutions,
                               int[] candidates, int target) {

        if (currentSum == target) {
            solutions.add(
                    new ArrayList<>(currentList)
            );
            return;
        }

        /*
            In this version of combination sum, it is allowed for the number, in candidates array, that we
            are standing on to be included several times in the current sum (and current list) until it
            reaches the target number. Then the last recursive layer returns and the next value in the
            iteration is exhausted and so on, until all iterations are exhausted in all the recursive layers
            and the very first call returns.
                I should also mention that candidates array in this version of combination sum does not
            contain repeated numbers, therefore there's no need to sort the candidates array first before
            recursing over it, unlike the second version of combination sum.
        */

        for (int i = startCandidatesIndex; i < candidates.length; i++) {
            if (currentSum + candidates[i] > target) continue;

            currentSum += candidates[i];
            currentList.add(candidates[i]);

            /*
                Due to the description in the comment above, that's why in the recursive call below we use
                the value i as the startCandidatesIndex of the new recursive layer, instead of i+1 in the
                combination sum 2 solution (the second version of this combination sum problem).
            */
            exhaustStates(currentList, currentSum, i, solutions, candidates, target);

            currentSum -= candidates[i];
            currentList.remove(currentList.size() - 1);
        }
    }
}
