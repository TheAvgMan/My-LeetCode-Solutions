package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        int[] reservedIndices = new int[nums.length];
        Arrays.fill(reservedIndices, 0);

        exhaustStates(new ArrayList<>(), reservedIndices, solutions, nums);

        return solutions;
    }

    private void exhaustStates(List<Integer> currentList, int[] reservedIndices,
                               List<List<Integer>> solutions, int[] nums) {

        if (currentList.size() == nums.length) {
            solutions.add(
                    new ArrayList<>(currentList)
            );
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (reservedIndices[i] == 1) continue;

            reservedIndices[i] = 1;
            currentList.add(nums[i]);

            exhaustStates(currentList, reservedIndices, solutions, nums);

            reservedIndices[i] = 0;
            currentList.remove(currentList.size() - 1);
        }
    }
}
