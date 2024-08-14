package DynamicProgProblems.ClimbingStairs.Recursive;

import java.util.Arrays;

class Solution {
    private int n;
    private int[] memo;

    int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 3) return n;

        this.n = n;
        memo = new int[this.n];

        Arrays.fill(memo, -1);

        return dpRecursive(0);
    }

    private int dpRecursive(int currentStair) {
        if (currentStair == n) return 1;
        if (currentStair > n) return 0;

        if (memo[currentStair] == -1)
            memo[currentStair] = dpRecursive(currentStair + 1) +
                    dpRecursive(currentStair + 2);

        return memo[currentStair];
    }
}
