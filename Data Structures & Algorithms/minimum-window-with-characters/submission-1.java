class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0;
        int need = map.size();
        StringBuilder sb = new StringBuilder();
        int result = Integer.MAX_VALUE;
        int l = 0;
        int [] res = new int [] {-1, -1};
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(map.containsKey(c) && window.get(c).equals(map.get(c))) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < result) {
                    result = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);

                if(map.containsKey(leftChar) && window.get(leftChar) < map.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
