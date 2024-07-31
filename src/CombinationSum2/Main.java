package CombinationSum2;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(solution.combinationSum2(candidates, target));

        candidates = new int[] {2,5,2,1,2};
        target = 5;

        System.out.println(solution.combinationSum2(candidates, target));

    }
}
