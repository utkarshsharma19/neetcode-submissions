class Solution {
          HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
          return dfs(n, 0);
    }
    private int dfs(int n, int i) {
        if(i > n ) {
            return 0;
        }
        if(i == n ) {
            return 1;
        }

        if(map.containsKey(i)) {
            return map.get(i);
        }

        int result = dfs(n, i + 1) + dfs(n, i + 2);
        map.put(i, result);

        return result;
    }
}
