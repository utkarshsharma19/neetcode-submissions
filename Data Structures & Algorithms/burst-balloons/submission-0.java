class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums [] = new int[n + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        HashMap<String, Integer> memo = new HashMap<>();

        for(int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int result = dfs(newNums, 0, newNums.length - 1, memo);

        return result;
    }

    private int dfs(int[] nums, int left, int right, HashMap<String, Integer> memo){
        if(left + 1 == right) {
            return 0;
        }

        String key = left + " " + right;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int maxCoins = 0;
        for(int i = left + 1; i < right; i++) {
            int coins = nums[left] * nums[right] * nums[i];

            coins += dfs(nums, left, i ,memo);
            coins += dfs(nums, i, right, memo);    
            maxCoins = Math.max(maxCoins, coins);
            
        }

        memo.put(key, maxCoins);

        return maxCoins;
    }


}

//find min do the math om the index, remove the element from the array, do it recusively until the array length is 0
