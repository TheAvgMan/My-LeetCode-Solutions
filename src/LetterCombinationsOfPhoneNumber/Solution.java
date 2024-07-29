package LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> letterCombinations(String digits) {
        StringBuilder digitsSB = new StringBuilder(digits);

        List<String> combinations = new ArrayList<>();

        char [][] mapNumbersToLetters = {
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        exhaustStates(digitsSB, new StringBuilder(), combinations, mapNumbersToLetters);

        if (combinations.size() == 1) {
            combinations.remove(0);
        }

        return combinations;
    }

    private void exhaustStates(StringBuilder digitsSB, StringBuilder currentCombination,
                               List<String> combinations, char[][] mapNumbersToLetters) {

        if (digitsSB.isEmpty()) {
            combinations.add(currentCombination.toString());
            return;
        }

        char currentDigit = digitsSB.charAt(0);
        digitsSB.deleteCharAt(0);

        for (var letter : mapNumbersToLetters[currentDigit - 48]) {
            currentCombination.append(letter);
            exhaustStates(digitsSB, currentCombination, combinations, mapNumbersToLetters);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }

        digitsSB.insert(0, currentDigit);
    }
}
