class Solution {
    HashMap<String, Integer> map;
    public int longestCommonSubsequence(String text1, String text2) {
        map = new HashMap<>();
        return longestCommonSubsequenceHelper(text1, text2, 0, 0);
    }

    private int longestCommonSubsequenceHelper(String text1, String text2, int i, int j) {
        
        if( i == text1.length() || j == text2.length() ) {
            return 0;
        }

        String key = i + " " + j;

      if(  map.containsKey(key)) {
            return map.get(key);
        }
        int ans;
        if(text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + longestCommonSubsequenceHelper(text1, text2, i + 1, j + 1);
        } else {
            ans =  Math.max(longestCommonSubsequenceHelper(text1, text2, i, j+1), 
            longestCommonSubsequenceHelper(text1, text2, i + 1, j));
        }

        map.put(key, ans);

        return ans;
    }
}
