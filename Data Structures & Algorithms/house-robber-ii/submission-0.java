class Solution {
    public int rob(int[] nums) {

         int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRecursive(nums, 0, n - 2, new HashMap<>()),
                        robRecursive(nums, 1, n - 1, new HashMap<>()));
    }

    public int robRecursive(int[] nums, int i, int end, HashMap<Integer, Integer> memo) {
         if (i > end) return 0;

         if (memo.containsKey(i)) return memo.get(i);

        int canRob = nums[i] + robRecursive(nums, i + 2, end, memo);
        int skip = robRecursive(nums, i + 1, end, memo);
        int result = Math.max(canRob, skip);

        memo.put(i, result);
        return result;


    }
}
