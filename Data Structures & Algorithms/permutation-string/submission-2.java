class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> count1 = new HashMap<>();

        for(char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        int need = count1.size();

        for(int i =0; i < s2.length(); i++) {
        HashMap<Character, Integer> have = new HashMap<>();
            int cur =0;
            for(int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                have.put(c, have.getOrDefault(c, 0) + 1);

                if(count1.getOrDefault(c, 0) < have.put(c, have.getOrDefault(c, 0))) {
                    break;
                }
                if(count1.getOrDefault(c, 0) == have.get(c)) {
                    cur++;
                }

                if(cur == need) {
                    return true;
                }
            }
        }
        return false;
    }
}
