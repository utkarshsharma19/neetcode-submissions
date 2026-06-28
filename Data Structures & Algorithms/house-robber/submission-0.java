class Solution {
    public int rob(int[] nums) {
     if(nums.length == 0){
        return 0;
     }
     HashMap<Integer, Integer> hm = new HashMap<>();


    int result = dfs(nums, 0, hm);

    return result;
    }

    private int dfs(int [] nums, int i, HashMap<Integer, Integer> memo) {
        
        if( i >= nums.length) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

       int robCurrent = nums[i] + dfs(nums, i + 2, memo);
        int skipCurrent = dfs(nums, i + 1, memo);

       int result = Math.max(robCurrent, skipCurrent);

        memo.put(i, result);


        return result;
    }
}
