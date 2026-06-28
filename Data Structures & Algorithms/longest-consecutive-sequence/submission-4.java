class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums) {
            set.add(num);
        }

        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int current = nums[i];
                int count = 1;
                while(set.contains(current + 1)) {
                    current++;
                    count++;
                }
            longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}
