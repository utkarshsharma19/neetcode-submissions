class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lowestEating = 1;
        int highestEating = 1;

        for (int p : piles) highestEating = Math.max(highestEating, p);
        int res = 0;
        while(lowestEating <= highestEating) {
            int k = (lowestEating + highestEating) / 2;
            int totalTime = 0;
            for(int p : piles) {
                totalTime +=  (p + k - 1) /k;
            }

            if(totalTime <= h) {
                res = k;
                highestEating = k - 1;
            } else {
                lowestEating = k + 1;
            }
        }

        return res;
    }
}



// each pile takes ceil(pile.length/h)