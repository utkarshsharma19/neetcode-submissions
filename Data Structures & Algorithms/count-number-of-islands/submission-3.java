class Solution {
    int ROWS;
    int COLS;
    public int numIslands(char[][] grid) {
        int count = 0;
        ROWS = grid.length;
        COLS = grid[0].length;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if(r >= ROWS || c >= COLS || c < 0 || r < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }
}
