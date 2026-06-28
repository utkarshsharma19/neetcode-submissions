class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int result = 0;  
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(right - left + 1 - calculateMax(map) > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }

                left++;
            }

            result = Math.max(right - left  + 1, result);
            right++;
        }

        return result;
    }

    private int calculateMax(HashMap<Character, Integer> map) {
        int maxVal = Integer.MIN_VALUE;

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            maxVal = Math.max(val, maxVal);
        }

        return maxVal;
    }
}
