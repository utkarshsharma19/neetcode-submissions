class Solution {
    public int dfs(int i, int j, int m , int n, HashMap<String, Integer> map) {
        String key = i + " " + j;
        
        if(i == m - 1 && j == n -1) {
            return 1;
        }

        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(i >= m || j >= n) {
            return 0;
        }

        int rightPath = dfs(i, j + 1, m, n , map);
        int leftPath = dfs(i + 1, j, m, n , map);
        map.put(key, rightPath + leftPath);

        return map.get(key);

    }
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();

        return dfs(0,0,m, n, map);
    }
}
