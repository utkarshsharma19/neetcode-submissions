class Solution {
    HashSet<Integer> posDiaMap = new HashSet<>();
    HashSet<Integer> negposDiaMap = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board, cols, posDiaMap, negposDiaMap);

        return result;
    }

    private void backtrack(int r, int n, char [][] board, Set<Integer> cols,
    HashSet<Integer> posDiaMap , HashSet<Integer> negposDiaMap ) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }
        for(int c = 0; c < n; c++) {
            if(cols.contains(c) || posDiaMap.contains(r + c) || negposDiaMap.contains(r -c)) {
                continue;
            }

            board[r][c] = 'Q';
            posDiaMap.add(r + c);
            negposDiaMap.add(r - c);
            cols.add(c);
            backtrack(r + 1, n, board, cols, posDiaMap, negposDiaMap);
            board[r][c] = '.';
            posDiaMap.remove(r + c);
            negposDiaMap.remove(r - c);
            cols.remove(c);
        }
    }
}
