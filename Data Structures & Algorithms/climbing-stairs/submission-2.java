class Solution {
    int [] dp;
    public int climbStairs(int n) {
        dp = new int[n];
        for(int i = 0; i < n ; i++) {
            dp[i] = -1;
        }
       return climbStairs(n, 0, dp);
    }

    private int climbStairs(int n, int i, int [] dp) {
        if(i >= n) {
            return i == n ? 1 : 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        return dp[i] = climbStairs(n, i + 1, dp) + climbStairs(n , i + 2, dp);
    }
}
