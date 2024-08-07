package BacktrackingProblems.GrayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int n;
    private StringBuilder binarySB;
    private List<Integer> solution;

    List<Integer> grayCode(int n) {
        this.n = n;
        binarySB = new StringBuilder();
        solution = new ArrayList<>();

        exhaustStates(false);

        return solution;
    }

    private void exhaustStates(boolean toggleVariable) {

        if (binarySB.length() == n) {
            solution.add(
                    Integer.parseInt(binarySB.toString(),2)
            );
            return;
        }

        if (!toggleVariable) {
            for (int i = 0; i <= 1; i++) {
                binarySB.append(i);
                exhaustStates(i != 0);
                binarySB.deleteCharAt(binarySB.length() - 1);
            }
        } else {
            for (int i = 1; i >= 0; i--) {
                binarySB.append(i);
                exhaustStates(i == 0);
                binarySB.deleteCharAt(binarySB.length() - 1);
            }
        }
    }
}
