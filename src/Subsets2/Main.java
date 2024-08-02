package Subsets2;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2};
        System.out.println(solution.subsets2(nums));

        nums = new int[] {0};
        System.out.println(solution.subsets2(nums));
    }
}
