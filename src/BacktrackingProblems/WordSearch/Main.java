package BacktrackingProblems.WordSearch;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";

        System.out.println(solution.exist(board, word));

        word = "SEE";

        System.out.println(solution.exist(board, word));

        word = "ABCB";

        System.out.println(solution.exist(board, word));

        board = new char[][] {
                {'a'}
        };

        word = "a";

        System.out.println(solution.exist(board, word));

        word = "b";

        System.out.println(solution.exist(board, word));
    }
}
