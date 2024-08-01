package Permutations;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};

        System.out.println(solution.permute(nums));

        nums = new int[] {0,1};

        System.out.println(solution.permute(nums));
    }
}
