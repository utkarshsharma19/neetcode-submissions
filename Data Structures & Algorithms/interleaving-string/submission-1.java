class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> hs = new HashMap<>();

        return dfs(s1,s2,s3,0,0,0, hs);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, HashMap<String, Boolean> hs) {
        if(k == s3.length()) {
            return ((i == s1.length()) && (j == s2.length()));
        }

        String key = i + " " + j;
        if(hs.containsKey(key)) {
           return hs.get(key);
        }
  boolean valid = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            valid |= dfs(s1, s2, s3, i + 1, j, k + 1, hs);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            valid |= dfs(s1, s2, s3, i, j + 1, k + 1, hs);
        }
        hs.put(key, valid);
        return valid;
    }
}
