class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        HashMap<Character, String> hs = new HashMap<>();
        hs.put('2', "abc");
        hs.put('3', "def");
        hs.put('4', "ghi");
        hs.put('5', "jkl");
        hs.put('6', "mno");
        hs.put('7', "pqrs");
        hs.put('8', "tuv");
        hs.put('9', "wxyz");

dfs(digits, 0, new StringBuilder(), hs, result);
        return result;
    }

    private void dfs( String digits, int index, StringBuilder current, HashMap<Character , String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letter = map.get(digit);

        for(char letters: letter.toCharArray()) {
            current.append(letters);
            dfs(digits, index + 1, current, map, result);
            current.deleteCharAt(current.length() - 1);

        }
    }
}
