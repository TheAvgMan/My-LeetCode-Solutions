package BacktrackingProblems.CombinationSum;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int [] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(solution.combinationSum(candidates, target));

        candidates = new int[] {2, 3, 5};
        target = 8;

        System.out.println(solution.combinationSum(candidates, target));

        candidates = new int[] {2};
        target = 1;

        System.out.println(solution.combinationSum(candidates, target));
    }
}
