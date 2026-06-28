class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> memo = new HashMap<>();

        return dfs(0,0, m, n, memo);
    }

    private int dfs(int i ,int j, int m, int n, HashMap<String, Integer> memo) {
        String key = i + " " + j;
        if(i == m - 1 && j == n -1) {
            return 1;
        }

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if( i >=m || j>=n) {
            return 0;
        }

        int rightPaths = dfs(i, j + 1, m, n, memo);
        int downPaths = dfs(i + 1, j, m, n, memo);

        memo.put(key, rightPaths+downPaths);

        return memo.get(key);
    }
}
