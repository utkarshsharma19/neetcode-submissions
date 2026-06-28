class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()) {
            int length = 0;
            while(set.contains(s.charAt(right)) && left < right)  {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }
}
