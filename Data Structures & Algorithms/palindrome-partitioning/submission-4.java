class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        partitionHelper(s, 0, list);

        return result;
    }

    private void partitionHelper(String s, int index, List<String> list) {
        if(index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if(isPalindrome(sub)) {
                list.add(sub);
                partitionHelper(s, i +1, list);
                list.remove(list.size() -1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
