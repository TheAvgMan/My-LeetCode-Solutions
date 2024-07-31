package CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<>();

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
