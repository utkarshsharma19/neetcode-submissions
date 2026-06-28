class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(0, amount, coins, memo);
    }

    private int dfs(int i, int a, int[] coins, int[][] memo) {
        if (a == 0) return 1;
        if (i == coins.length) return 0;
        if (memo[i][a] != -1) return memo[i][a];

        int res = dfs(i + 1, a, coins, memo); // skip current coin

        if (a >= coins[i]) {
            res += dfs(i, a - coins[i], coins, memo); // take current coin
        }

        memo[i][a] = res;
        return res;
    }
}