class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        HashMap<Integer, Integer> memo = new HashMap<>();

        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
    }

    private int minCost(int[] cost, int i, HashMap<Integer,Integer> memo ) {
        if (i >= cost.length) {
            return 0;
        }
        
        if(memo.containsKey(i)) {
            return memo.get(i);
        }

        int jump = cost[i] + Math.min(minCost(cost, i + 1, memo), minCost(cost, i + 2, memo));

        memo.put(i, jump);
    
    return jump;
    }
}
