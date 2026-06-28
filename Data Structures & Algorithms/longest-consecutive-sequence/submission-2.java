class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
    int length = 0;
        for(int num: nums) {
            hs.add(num);
        }
        int longest = 0;
        for(int num: hs) {
            if(!hs.contains(num - 1)) {
                length = 1;
                while(hs.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
