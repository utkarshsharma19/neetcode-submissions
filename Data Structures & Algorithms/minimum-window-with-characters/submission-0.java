
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = t.length();
        int left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (need.containsKey(rc)) {
                int cnt = need.get(rc);
                if (cnt > 0) required--;     // satisfied one needed char
                need.put(rc, cnt - 1);       // can go negative (extra copies)
            }

            while (required == 0) {
                // update best window
                int winLen = right - left + 1;
                if (winLen < minLen) {
                    minLen = winLen;
                    start = left;
                }

                char lc = s.charAt(left++);  // move left forward by 1
                if (need.containsKey(lc)) {
                    need.put(lc, need.get(lc) + 1); // give it back
                    if (need.get(lc) > 0) {         // now missing one lc
                        required++;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
