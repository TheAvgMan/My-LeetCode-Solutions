package BacktrackingProblems.LetterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> letterCombinations(String digits) {
        StringBuilder digitsSB = new StringBuilder(digits);

        List<String> combinations = new ArrayList<>();

        /*
            The below character 2D array acts as a map that maps numbers (in this case they are
            represented as indices here) to their letters found on old mobile phones' keypads.
            So you would access this 2D array using the number you target (as an index) and that would
            return an array of the letters corresponding to this number (as if on an old mobile phone
            keypad).
        */

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

        /*
            If the combinations list returned empty, it would contain one character element which is
            empty character (""), but we don't want it, so we remove it by the below condition.
        */

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

        /*
            In this portion of code, we take each digit (from the front) in the digits string and use it
            to access the character 2D array to iteratively recurse on its returned array to exhaust it
            along with the other digits' arrays to form all the possible letter combinations.
        */

        for (var letter : mapNumbersToLetters[currentDigit - 48]) {
            currentCombination.append(letter);
            exhaustStates(digitsSB, currentCombination, combinations, mapNumbersToLetters);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }

        digitsSB.insert(0, currentDigit);
    }
}
