class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        int res = l;

        while(l <= r) {
            int k = l + (r - l)/2;

            int totalTime = 0;

            for(int pile: piles) {
                totalTime += (pile + k - 1) / k;
            }

            if(totalTime <= h) {
                                res = k;
                r =  k-1;
            } else {
                l = k + 1;
            }
        }
    return res;
    }
}
