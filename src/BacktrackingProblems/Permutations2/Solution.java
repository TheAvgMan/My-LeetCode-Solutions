package BacktrackingProblems.Permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> solutions;
    private List<Integer> currentList;
    private boolean[] reservedIndices;
    private int[] nums;

    List<List<Integer>> permute2(int[] nums) {
        solutions = new ArrayList<>();
        currentList = new ArrayList<>();
        this.nums = nums;
        reservedIndices = new boolean[this.nums.length];

        Arrays.fill(reservedIndices, false);

        // As in combination sum 2 solution, this sorting step is EXTREMELY IMPORTANT
        Arrays.sort(this.nums);

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

            /*
                In this loop, we iterate over the whole nums array in each recursive layer to check what
                values have been used (to skip them) and what are the free values (to include them in the
                current list).
                    Similar to combination sum 2 solution, in the condition below, we check if, not only
                is the value reserved or not, but also if the value before it is the same. If it is the
                same, then if the previous value is already used / reserved, then there's no problem with
                taking the current value into the current list as well, because the previous value was
                used in a previous recursive layer. But if the previous value is not used / reserved
                then we skip the current value because it'll repeat the same exhaustion path of the
                previous value.
                    So, finally, if the current value is free and not the same as the previous value, then
                we pass by the 2 continue statements and go right away to the backtracking portion of the
                code below.
            */

            if (i != 0)
                if (nums[i] == nums[i-1] && !reservedIndices[i-1]) continue;

            reservedIndices[i] = true;
            currentList.add(nums[i]);
            exhaustStates();
            reservedIndices[i] = false;
            currentList.remove(currentList.size() - 1);
        }
    }
}
