class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        int res = left;

        while( left <= r) {
            int k = left + (r - left)/2;
            int totalTime = 0;

            for(int pile: piles) {
                totalTime += (pile + k - 1) / k;
            }

            if(totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                left = k + 1;
            }
        }
    return res;

    }
}
