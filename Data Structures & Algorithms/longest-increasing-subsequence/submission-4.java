
class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dfs(nums, i));
        }

        return ans;
    }

    private int dfs(int[] nums, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int best = 1; // at least nums[i] itself

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                best = Math.max(best, 1 + dfs(nums, j));
            }
        }

        memo.put(i, best);
        return best;
    }
}