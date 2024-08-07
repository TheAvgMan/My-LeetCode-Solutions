package BacktrackingProblems.CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();

        // An EXTREMELY IMPORTANT STEP is this sorting of the candidates array before going into recursion.
        Arrays.sort(candidates);

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

        int previousCandidate = -1;

        /*
            In this version of combination sum, we cannot have a number from candidates array repeated in
            the current sum, that is, the same number in that position taken into current sum several times.
            But if a number is repeated in the candidates array itself then they account as different
            candidates because they are in different positions in the candidates array, therefore each of them
            can be taken into current sum.
                Based on this description, that's why in the recursive call below, you see the
            startCandidatesIndex as i+1.
                Also, because the candidates array, in this version, can contain repeated numbers, so it is
            a MUST to sort the candidates array before recursing on it. That's because it's faster and more
            efficient to deal with the repeated numbers in the candidates array when it's sorted.
                Due to all of this description, there needed to exist an efficient way in our code to prevent
            the duplication of combinations in the solutions array. And that's why previous candidate variable
            was introduced, to prevent adding again to current sum the same value that was in the previous
            iteration in the same recursive layer.
        */

        for (int i = startCandidatesIndex; i < candidates.length; i++) {
            if (candidates[i] == previousCandidate) continue;
            if (currentSum + candidates[i] > target) continue;

            currentSum += candidates[i];
            currentList.add(candidates[i]);

            exhaustStates(currentList, currentSum, i + 1, solutions, candidates, target);

            currentSum -= candidates[i];
            currentList.remove(currentList.size() - 1);

            previousCandidate = candidates[i];
        }
    }
}
