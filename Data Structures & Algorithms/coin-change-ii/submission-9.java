class Solution {
    public int change(int amount, int[] coins) {
        int [][] memo = new int[coins.length + 1][amount + 1];
       for(int [] row: memo) {
        Arrays.fill(row , -1);
       }

       return dfs(0, amount, coins, memo);
    }

    private int dfs(int i, int amount, int[] coins, int[][] memo) {
        if(amount == 0) {
            return 1;
        }

        if( i >= coins.length) {
            return 0;
        }
        if(memo[i][amount] != -1) {
            return memo[i][amount];
        }

        int res = 0;

        if(amount >= coins[i]) {
            res += dfs(i,amount - coins[i], coins, memo);
        }

        res += dfs(i + 1, amount, coins, memo);

        memo[i][amount] = res;

        return res;
    }
}

//using dp recursion we can say that we choose one coin and then we do not choose one coin and see. 
//using bottom up approach-> dp[0] = 0 