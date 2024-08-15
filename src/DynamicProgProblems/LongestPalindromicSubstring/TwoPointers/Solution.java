package DynamicProgProblems.LongestPalindromicSubstring.TwoPointers;

class Solution {
    private String s;
    private int s_size;

    String longestPalindrome(String s) {
        this.s = s;
        s_size = this.s.length();

        int[] result = indicesOfLongestPalindromicSubstring();

        return this.s.substring(result[0], result[1] + 1);
    }

    private int[] indicesOfLongestPalindromicSubstring() {
        int substringStart = 0;
        int substringEnd = 0;

        int left = 0, right = 0;
        for (int i = 0; i < s_size; i++) {
            // odd palindromes first
            left = i;
            right = i;

            while(left >= 0 && right < s_size && s.charAt(left) == s.charAt(right)) {
                if (right - left > substringEnd - substringStart) {
                    substringStart = left;
                    substringEnd = right;
                }
                left--;
                right++;
            }

            // then even palindromes
            left = i;
            right = i + 1;

            while(left >= 0 && right < s_size && s.charAt(left) == s.charAt(right)) {
                if (right - left > substringEnd - substringStart) {
                    substringStart = left;
                    substringEnd = right;
                }
                left--;
                right++;
            }
        }

        return new int[] {substringStart, substringEnd};
    }
}
