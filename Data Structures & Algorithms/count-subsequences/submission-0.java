class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        HashMap<String, Integer> hm = new HashMap<>();
        return dfs(s, t, 0, 0, hm);

    }

    private int dfs(String s, String t, int i, int j, Map<String, Integer> hs) {
        if( j == t.length()) {
            return 1;
        }


        if( i == s.length()) {
            return 0;
        }

        String key = i + " " + j;

        if(hs.containsKey(key)) {
            return hs.get(key);
        }
        int res = dfs(s, t, i + 1, j, hs);

        if(s.charAt(i) == t.charAt(j)) {
            res += dfs(s, t, i + 1, j + 1, hs);
        }

        hs.put(key, res);

        return res;
    }
}
