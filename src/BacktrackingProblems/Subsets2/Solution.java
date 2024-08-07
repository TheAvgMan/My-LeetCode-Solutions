package BacktrackingProblems.Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();

        Arrays.sort(nums);

        exhaustStates(0, new ArrayList<>(), solutions, nums);

        return solutions;
    }

    private void exhaustStates(int loopStartIndex, List<Integer> currentList,
                               List<List<Integer>> solutions, int[] nums) {

        solutions.add(
                new ArrayList<>(currentList)
        );

        /*
            I had to set a value less than -10 to pass all test cases on LeetCode, so I chose -100, so
            it was not for a certain reason.
        */
        int previousNumber = -100;

        for (int i = loopStartIndex; i < nums.length; i++) {
            if (nums[i] == previousNumber) continue;

            currentList.add(nums[i]);
            exhaustStates(i + 1, currentList, solutions, nums);
            currentList.remove(currentList.size() - 1);

            previousNumber = nums[i];
        }
    }
}
