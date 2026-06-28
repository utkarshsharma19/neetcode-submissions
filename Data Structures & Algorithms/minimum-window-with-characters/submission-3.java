class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int result = Integer.MAX_VALUE;
        int [] res = new int[]{-1,-1};
        int have = 0;
        int need = map.size();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(map.containsKey(ch) && window.get(ch).intValue() == map.get(ch).intValue()) {
                have++;
            }

            while(have == need) {
                if(right - left + 1 < result) {
                    result = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(map.containsKey(leftChar) && window.get(leftChar) < map.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
