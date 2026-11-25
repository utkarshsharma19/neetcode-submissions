class Solution {
    public int numDecodings(String s) {
    HashMap<Integer, Integer> map = new HashMap<>();
        map.put(s.length(), 1);
        return dfs(0, s, map);
    }

    private int dfs(int i, String s, HashMap<Integer, Integer> map) {
        if(map.containsKey(i)) {
            return map.get(i);
        }

        if(s.charAt(i) == '0') {
            return 0;
        }
        int res = dfs(i + 1, s, map);

        if(i < s.length() - 1) {
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7') {
                res += dfs(i + 2, s, map);
            }
        }
        map.put(i, res);
    return res;
    }
}


// Time complexity: O(2^n);
// Space: O(n)
