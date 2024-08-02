package Permutations2;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};

        System.out.println(solution.permute2(nums));

        nums = new int[] {1,1,2};

        System.out.println(solution.permute2(nums));
    }
}
