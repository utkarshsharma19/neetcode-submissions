class Solution {
    private Set<Pair<Integer, Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char [][] board, String word, int r, int c, int i) {
        int n = board.length;
        int m = board[0].length;

        if(i == word.length()) {
            return true;
        }

        if(r < 0 || c < 0 || r >= n || c>= m || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r, c))) {
            return false;
        }

        path.add(new Pair<>(r, c));

                boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);

                      path.remove(new Pair<>(r, c));

                      return res;
    }
}
