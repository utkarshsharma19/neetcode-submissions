class Solution {
    public int swimInWater(int[][] grid) {
       int min = grid[0][0];
       int max = grid[0][0]; 

       for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[0].length; j++) {
            max = Math.max(max, grid[i][j]);
            min = Math.min(max, grid[i][j]);
        }
       }

       int left =min;

       int right = max;

       while(left < right) {
        int mid = left + (right - left)/2;

        boolean[][] visit = new boolean[grid.length][grid[0].length];

        if(grid[0][0] <= mid && dfs(grid, visit, 0, 0, mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
       }

    return left;

    }

    private boolean dfs(int[][] grid, boolean[][] visit, int r, int c, int t) {
        int n = grid.length;
        if (r < 0 || c < 0 || r >= n || c >= n || visit[r][c] || grid[r][c] > t) {
            return false;
        }
        if (r == n - 1 && c == n - 1) {
            return true;
        }
        visit[r][c] = true;

        return dfs(grid, visit, r + 1, c, t) || 
               dfs(grid, visit, r - 1, c, t) || 
               dfs(grid, visit, r, c + 1, t) || 
               dfs(grid, visit, r, c - 1, t);
    }
}
