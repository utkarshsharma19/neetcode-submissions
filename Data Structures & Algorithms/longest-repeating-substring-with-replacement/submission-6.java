class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int answer = 0;
        int n = s.length();
        for(int right = 0; right < n; right++){ 
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            int windowSize = right - left + 1;

            while(windowSize - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
                windowSize = right - left + 1;
            }

            answer = Math.max(answer, windowSize);
        }        
    return answer;

    }
}
