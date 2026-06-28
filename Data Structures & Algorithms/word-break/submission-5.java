class Solution {
    HashMap<Integer, Boolean> memo = new HashMap<>();
    HashSet<String> wordSet;
    int maxLen;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);

        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        return dfs(s, 0);
    }

    private boolean dfs(String s, int i) {
        if (i == s.length()) return true;
        if (memo.containsKey(i)) return memo.get(i);

        for (int end = i + 1; end <= s.length() && end <= i + maxLen; end++) {
            if (wordSet.contains(s.substring(i, end)) && dfs(s, end)) {
                memo.put(i, true);
                return true;
            }
        }

        memo.put(i, false);
        return false;
    }
}