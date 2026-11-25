class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result = checkSum(coins, amount);

       return (result >= Integer.MAX_VALUE) ? -1 : result;

    }


    private int checkSum(int [] coins, int amount) {


        if(amount == 0) {
            return 0;
        }
        if(map.containsKey(amount)) {
            return map.get(amount);
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(amount - coins[i] >=0) {

                int res = checkSum(coins, amount - coins[i]);
                if(res != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + res);
                }
            }
        }
            map.put(amount, result);

        return result;
    }
}
// TC: O (N to power A)