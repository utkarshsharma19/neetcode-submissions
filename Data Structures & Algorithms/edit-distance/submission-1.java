class Solution {
    public int minDistance(String word1, String word2) {
         int m = word1.length(), n = word2.length();
         Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, word1, word2, m, n, memo);
    }

      private int dfs(int i, int j, String word1, String word2, int m, int n, Map<String, Integer> memo) {
        if (i == m) return n - j;
        if (j == n) return m - i;

         String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dfs(i + 1, j + 1, word1, word2, m, n, memo);
        }

        int deleteOp = dfs(i + 1, j, word1, word2, m, n, memo);
        int insertOp = dfs(i, j + 1, word1, word2, m, n, memo);
        int replaceOp = dfs(i + 1, j + 1, word1, word2, m, n, memo);

         int result = 1 + Math.min(deleteOp, Math.min(insertOp, replaceOp));
        memo.put(key, result);

        return result;
    }

}
