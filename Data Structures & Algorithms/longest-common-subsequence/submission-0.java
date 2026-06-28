
class Solution {
    private HashMap<String, Integer> memo = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String text1, String text2, int i, int j) {
        if( i == text1.length() || j == text2.length() ) {
            return 0;
        }

        String key = i + "," + j;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;
        if (text1.charAt(i) == text2.charAt(j)) {
            result = 1 + dfs(text1, text2, i + 1, j + 1);
        } else {
            result = Math.max(dfs(text1, text2, i + 1, j), dfs(text1, text2, i, j + 1));
        }

         memo.put(key, result);

         return result;
    }
}
