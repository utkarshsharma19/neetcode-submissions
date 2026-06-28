class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }
        
        int longest = 0;
        for(int num: hs) {
            if(!hs.contains(num - 1)) {
                int length = 1;
                while(hs.contains(num + 1)) {
                    length++;
                    num++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
