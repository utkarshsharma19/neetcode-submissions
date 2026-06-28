class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = 0;
        int maxSub = nums[0];

        for(int num:nums) {
            if(currMax < 0) {
                currMax = 0;
            }
            currMax += num;
            maxSub = Math.max(currMax, maxSub);

            }
        return maxSub;
        }
    }

//kadens