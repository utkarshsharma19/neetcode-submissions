class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();

        for(int i =0; i < nums.length; i++) {
            set.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if(set.containsKey(target - nums[i]) && set.get(target - nums[i]) != i) {
                return new int [] {i, set.get(target - nums[i])};
            }
        }
        return new int [] {0,0};
    }
}
