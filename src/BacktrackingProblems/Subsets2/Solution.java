package BacktrackingProblems.Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> solutions;
    private List<Integer> currentList;
    private int[] nums;

    List<List<Integer>> subsets2(int[] nums) {
        solutions = new ArrayList<>();
        currentList = new ArrayList<>();
        this.nums = nums;

        Arrays.sort(this.nums);

        exhaustStates(0);

        return solutions;
    }

    private void exhaustStates(int loopStartIndex) {

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
            exhaustStates(i + 1);
            currentList.remove(currentList.size() - 1);

            previousNumber = nums[i];
        }
    }
}
