class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        int right = 0;
        int left = 0;
        while(right < s.length()) {
            while(set.contains(s.charAt(right)) && left < right) {
                set.remove(s.charAt(left));
                left++;

            }
            set.add(s.charAt(right));
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
