class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int result = 0;
        for(int right = 1; right < prices.length; right++) {
            if(prices[left] < prices[right]) {
            int profit = prices[right] - prices[left];
            result = Math.max(result, profit);
            } else {
                left = right;
            }
        }
        return result;
    }
}
