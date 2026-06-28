class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> setS1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            setS1.put(ch, setS1.getOrDefault(ch, 0) + 1);
        }

        int need = setS1.size();
        for(int i = 0; i < s2.length(); i++) {
        int curr = 0;
        HashMap<Character, Integer> setS2= new HashMap<>();
        for(int j = i; j < s2.length(); j++) {
            char ch = s2.charAt(j);
            setS2.put(ch, setS2.getOrDefault(ch, 0) + 1);

            if(setS1.getOrDefault(ch, 0) < setS2.get(ch)) {
                break;
            }
            if (setS1.getOrDefault(ch, 0) == setS2.get(ch)) {
                    curr++;
            }
            if (curr == need) {
                    return true;
            }
        }
    }
        return false;
    }
}
