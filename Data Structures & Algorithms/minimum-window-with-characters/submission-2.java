class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int result = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};

        int need = needMap.size();
        int have = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (needMap.containsKey(c) && window.get(c).intValue() == needMap.get(c).intValue()) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < result) {
                    result = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (needMap.containsKey(leftChar) && window.get(leftChar) < needMap.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return result == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}