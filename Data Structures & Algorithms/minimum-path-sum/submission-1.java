class Solution {
    public int minPathSum(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
                int n = grid.length;
        int m = grid[0].length;
        return dfs(grid, 0, 0, map, n, m);
    }

    private int dfs(int [][] grid, int i , int j, HashMap<String, Integer> map, int n , int m) {

         if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        String key = i + " " + j;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(i == n - 1 && j == m - 1) {
            return grid[i][j];
        }
            int left = dfs(grid, i + 1, j,map, n, m);
            int down = dfs(grid, i, j + 1, map, n, m);

            int ans = Math.min(left, down) + grid[i][j];

            map.put(key, ans);

            return ans;
    }
}