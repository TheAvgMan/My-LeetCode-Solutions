package BacktrackingProblems.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int stringSize;
    private String givenString;
    private List<List<String>> solutions;
    private List<String> currentList;

    List<List<String>> partition(String s) {
        solutions = new ArrayList<>();
        currentList = new ArrayList<>();
        givenString = s;
        stringSize = s.length();

        exhaustStates(new StringBuilder(), 0);

        return solutions;
    }

    private void exhaustStates(StringBuilder currentPartition, int startIndex) {

        if (startIndex == stringSize) {
            solutions.add(
                    new ArrayList<>(currentList)
            );
            return;
        }

        for (int i = startIndex; i < stringSize; i++) {
            currentPartition.append(givenString.charAt(i));
            if(!isPalindrome(currentPartition)) continue;

            currentList.add(currentPartition.toString());
            exhaustStates(new StringBuilder(), i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }

    private boolean isPalindrome(StringBuilder s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
