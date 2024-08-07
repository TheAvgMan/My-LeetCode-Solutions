package BacktrackingProblems.Subsets;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.subsets(nums));

        nums = new int[] {0};
        System.out.println(solution.subsets(nums));
    }
}
