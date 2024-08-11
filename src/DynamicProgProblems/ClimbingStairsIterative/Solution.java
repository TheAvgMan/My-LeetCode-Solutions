package DynamicProgProblems.ClimbingStairsIterative;

class Solution {
    int climbStairs(int n) {

        /*
            This is the bottom up approach for dynamic programming, which is essentially iterative, that's
            why the for loop is used. This is the traditional approach for dynamic programming. It's
            obviously more efficient than recursive approach especially memory-wise.

            In this problem specifically, the iterative approach shows the fibonacci series, but of course
            that's not the case with all dynamic programming problems solved by iterative approach.

            Here also, the two pointers / variables was used because not a whole array was needed, but
            that also may not always be the case.
        */

        int firstValue = 1, secondValue = 1;
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp = firstValue;
            firstValue += secondValue;
            secondValue = temp;
        }

        return firstValue;
    }
}
