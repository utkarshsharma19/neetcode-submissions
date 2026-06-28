class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        HashMap<String, Integer> memo = new HashMap<>();

        return changeHelper(amount, coins, 0, memo);
    }

    private int changeHelper(int amount, int [] coins, int i,   HashMap<String, Integer> memo) {
        if(amount == 0) {
            return 1;
        }

        if(i >= coins.length) {
            return 0;
        }

        String key = i + " " + amount;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = 0;
        if(amount >= coins[i]) {
            res = changeHelper(amount, coins, i + 1, memo);
            res +=changeHelper(amount - coins[i], coins, i, memo);
        }

        memo.put(key, res);
    return res;
        
    }
}
