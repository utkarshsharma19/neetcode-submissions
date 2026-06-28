class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        res.add("");

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            String letters = map.get(digit);

            for (String curr : res) {
                for (char c : letters.toCharArray()) {
                    temp.add(curr + c);
                }
            }

            res = temp;
        }

        return res;
    }
}