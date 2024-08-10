package BacktrackingProblems.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> solutions;
    private List<Integer> currentList;
    private boolean[] reservedIndices;
    private int[] nums;

    List<List<Integer>> permute(int[] nums) {
        solutions = new ArrayList<>();
        currentList = new ArrayList<>();
        this.nums = nums;
        reservedIndices = new boolean[this.nums.length];

        Arrays.fill(reservedIndices, false);

        exhaustStates();

        return solutions;
    }

    private void exhaustStates() {

        if (currentList.size() == nums.length) {
            solutions.add(
                    new ArrayList<>(currentList)
            );
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (reservedIndices[i]) continue;

            reservedIndices[i] = true;
            currentList.add(nums[i]);
            exhaustStates();
            reservedIndices[i] = false;
            currentList.remove(currentList.size() - 1);
        }
    }
}
