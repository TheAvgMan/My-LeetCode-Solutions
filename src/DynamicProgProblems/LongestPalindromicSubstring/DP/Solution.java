package DynamicProgProblems.LongestPalindromicSubstring.DP;

class Solution {
    private String s;
    private int s_size;
    private boolean[][] isPalindromeSubstring;

    String longestPalindrome(String s) {
        this.s = s;
        s_size = this.s.length();
        isPalindromeSubstring = new boolean[s_size][s_size];

        int[] result = indicesOfLongestPalindromicSubstring();

        StringBuilder resultSubstring = new StringBuilder();
        for (int i = result[0]; i <= result[1]; i++)
            resultSubstring.append(this.s.charAt(i));

        return resultSubstring.toString();
    }

    private int[] indicesOfLongestPalindromicSubstring() {

        int rangeSize = 0;
        int maxSubstringLength = 1;
        int substringStart = 0;
        int substringEnd = 0;

        do {
            for (int i = 0; i + rangeSize < s_size; i++) {
                if (s.charAt(i) == s.charAt(i + rangeSize)) {
                    if (rangeSize == 0 || rangeSize == 1 || isPalindromeSubstring[i + 1][i + rangeSize - 1]) {
                        isPalindromeSubstring[i][i + rangeSize] = true;
                        if ((rangeSize + 1) > maxSubstringLength) {
                            maxSubstringLength = rangeSize + 1;
                            substringStart = i;
                            substringEnd = i + rangeSize;
                        }
                    }
                }
            }
            rangeSize++;
        } while (rangeSize < s_size);

        return new int[] {substringStart, substringEnd};
    }
}
