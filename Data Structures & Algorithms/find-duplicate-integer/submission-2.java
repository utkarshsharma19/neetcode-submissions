class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // Step 1: move until they meet
        do {
            slow = nums[slow];          // 1 step
            fast = nums[nums[fast]];    // 2 steps
        } while (slow != fast);

        // Step 2: find the cycle start
        int start = 0;
        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }

        return start;
    }
}