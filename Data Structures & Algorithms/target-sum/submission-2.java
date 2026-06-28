class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> map = new HashMap<>();
        return dfs(0, 0, nums, target, map);
    }

    private int dfs(int i, int total, int [] nums, int target, HashMap<String, Integer> memo) {

        String key = i + " " + total;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(i == nums.length) {
            if(total == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int add =  dfs(i + 1, total + nums[i], nums, target, memo);
        int sub =  dfs(i + 1, total - nums[i], nums, target, memo);
        memo.put(key, add + sub);

    return add + sub;
    }

}   



// sliding window + negative value assign 