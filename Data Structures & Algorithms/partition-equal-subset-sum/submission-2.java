class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        HashMap<String, Boolean> memo = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

         if (sum % 2 != 0) {
            return false;
        }
        boolean result = canPartitionHelper(nums, 0, sum/2, memo);

        return result;

    }

    private boolean canPartitionHelper(int [] nums, int i, int target, HashMap<String, Boolean> memo) {
        if(i >= nums.length) {
            if(target == 0) {
                return true;
            }
            return false;
        }
        if(target < 0) {
            return false;
        }
        String key = i + "," + target;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }


        boolean  nonSelect = canPartitionHelper(nums, i +1, target, memo);
        boolean select = canPartitionHelper(nums, i + 1, target - nums[i], memo);

        boolean result = nonSelect || select;

        memo.put(key, result);
        return result;
    }
}