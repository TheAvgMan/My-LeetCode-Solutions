package BacktrackingProblems.Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> solutions;
    private List<Integer> currentList;
    private int[] nums;

    List<List<Integer>> subsets(int[] nums) {
        solutions = new ArrayList<>();
        currentList = new ArrayList<>();
        this.nums = nums;

        exhaustStates(0);

        return solutions;
    }

    private void exhaustStates(int loopStartIndex) {

        solutions.add(
                new ArrayList<>(currentList)
        );

        for (int i = loopStartIndex; i < nums.length; i++) {
            currentList.add(nums[i]);
            exhaustStates(i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
