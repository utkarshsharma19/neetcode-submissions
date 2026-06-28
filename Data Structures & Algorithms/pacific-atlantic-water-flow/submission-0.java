
class Solution {
    private int n, m;
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>(); // ArrayList (capital L)
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;

        n = heights.length;        // rows
        m = heights[0].length;     // cols

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Pacific: top row & left col
        for (int c = 0; c < m; c++) dfs(0, c, pacific, heights);      // top row
        for (int r = 0; r < n; r++) dfs(r, 0, pacific, heights);      // left col

        // Atlantic: bottom row & right col
        for (int c = 0; c < m; c++) dfs(n - 1, c, atlantic, heights); // bottom row
        for (int r = 0; r < n; r++) dfs(r, m - 1, atlantic, heights); // right col

        // Collect intersection
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c)); // add coordinates
                }
            }
        }
        return res; // return the result
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1]; // use d[1] for column step

            // bounds: rows use n, cols use m
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            // reverse flow condition: can only go to >= height
            if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited, heights);
            }
        }
    }
}
