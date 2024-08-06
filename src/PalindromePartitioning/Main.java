package PalindromePartitioning;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("abab"));
        System.out.println(solution.partition("aabb"));
        System.out.println(solution.partition("aaab"));
        System.out.println(solution.partition("aab"));
        System.out.println(solution.partition("a"));
    }
}
