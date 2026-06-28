
class Solution {
    public List<List<String>> partition(String s) {
        Map<String, Boolean> palindromeMemo = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result, palindromeMemo);
        return result;
    }

    private void partitionHelper(String s, int start, List<String> current,
                                 List<List<String>> result, Map<String, Boolean> palindromeMemo) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end, palindromeMemo)) {
                current.add(s.substring(start, end + 1));
                partitionHelper(s, end + 1, current, result, palindromeMemo);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right, Map<String, Boolean> memo) {
        String key = left + ":" + right;
        if (memo.containsKey(key)) return memo.get(key);

        int i = left, j = right;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                memo.put(key, false);
                return false;
            }
        }

        memo.put(key, true);
        return true;
    }
}
