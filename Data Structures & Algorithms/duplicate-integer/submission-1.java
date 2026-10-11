class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else{
                return true;
            }
        }
    return false;
    }
}