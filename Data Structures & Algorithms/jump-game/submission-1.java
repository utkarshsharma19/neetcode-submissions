class Solution {
    public boolean canJump(int[] nums) {
        

        int left = 0;
        int right = 0;

        while(right < nums.length - 1) {
            int jump = right;
            for(int i = left; i < right + 1; i++) {
                jump = Math.max(jump, nums[i] + i );
            }

            if (jump == right) {
                return false;
            }

            left = right + 1;
            right = jump;

        } 

        return true;
        
    }
}
