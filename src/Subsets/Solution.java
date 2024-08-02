package Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();

        exhaustStates(0, new ArrayList<>(), solutions, nums);

        return solutions;
    }

    private void exhaustStates(int loopStartIndex, List<Integer> currentList,
                               List<List<Integer>> solutions, int[] nums) {

        solutions.add(
                new ArrayList<>(currentList)
        );

        for (int i = loopStartIndex; i < nums.length; i++) {
            currentList.add(nums[i]);
            exhaustStates(i + 1, currentList, solutions, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}
