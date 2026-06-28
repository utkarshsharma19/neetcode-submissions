class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] leftMax = new int[nums.length];
        int [] rightMax = new int[nums.length];
        leftMax[0] = 1;
        rightMax[rightMax.length - 1] = 1;

        int [] result = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            leftMax[i] = nums[i - 1] * leftMax[i - 1]; 
        } 

        for(int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = nums[i + 1] * rightMax[i + 1]; 
        } 

        for(int i = 0; i < nums.length; i++) {
            result[i] = leftMax[i] * rightMax[i];
        }

        return result;
    }
}  

// approach 1: do a brute force O(n^2)
// approach 2: leftMax and rightMax 