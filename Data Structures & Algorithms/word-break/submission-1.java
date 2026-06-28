class Solution {
    HashMap<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);                
        HashSet<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, 0);
    }

    private boolean dfs(String s, HashSet<String> wordSet, int i) {
        if (memo.containsKey(i)) return memo.get(i);

        for (String w : wordSet) {
            int len = w.length();
            if (i + len <= s.length() && s.substring(i, i + len).equals(w)) {
                if (dfs(s, wordSet, i + len)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}