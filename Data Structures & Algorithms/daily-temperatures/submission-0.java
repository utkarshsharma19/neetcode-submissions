class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        
        for (int j = 0; j < temperatures.length; j++) {
            int i = j + 1;
            while (i < temperatures.length && temperatures[i] <= temperatures[j]) {
                i++;
            }
            if (i < temperatures.length) {
                res[j] = i - j;
            } else {
                res[j] = 0; // no warmer day
            }
        }
        
        return res;
    }
}