class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        HashMap<Character, Integer> setT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        int tLength = t.length();

        for(int i = 0; i < tLength; i++) {
            char ch = t.charAt(i);
            setT.put(ch, setT.getOrDefault(ch, 0) + 1);
        }

        int have = 0;
        int need = setT.size();
        int sLength = s.length();
        int left = 0;
        int res[] = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        for(int right = 0; right < sLength; right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(setT.containsKey(ch) && window.get(ch).equals(setT.get(ch))) {
                have++;
            }

            while(have == need) {
                if((right - left + 1) < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(setT.containsKey(leftChar) && window.get(leftChar) < setT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }  
            return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }
}
