class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int result = 0;
        for(int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            result = Math.max(result, r - left + 1);
        }
        return result;
    }
}
