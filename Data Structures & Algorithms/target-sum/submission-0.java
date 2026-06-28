class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int total, int [] nums, int target) {
        if(i == nums.length) {
            if(total == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(i + 1, total + nums[i], nums, target) + 
               dfs(i + 1, total - nums[i], nums, target);
    }
}


// sliding window + negative value assign 