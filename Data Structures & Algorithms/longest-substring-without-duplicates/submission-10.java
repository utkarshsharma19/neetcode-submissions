class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            set.add(ch);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
