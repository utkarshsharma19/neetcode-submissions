class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left =0;
        int right = 0;
        int result =0;
        while(right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while(right - left + 1 -  caluclateMax(map)> k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(right - left + 1, result);
            right++;
        }

        return result;
    }


// will always be maximum of O(26);
    private int caluclateMax(HashMap<Character, Integer> map) {
        int maxValue = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            maxValue = Math.max(maxValue, val);
        }

        return maxValue;
    }
}
