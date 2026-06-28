class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);

        int left = 1, right = max; // speed range is [1..max]
        while (left < right) {
            int mid = left + (right - left) / 2; // candidate speed
            if (canFinish(piles, h, mid)) {
                right = mid;        // feasible -> try smaller
            } else {
                left = mid + 1;     // not feasible -> try larger
            }
        }
        return left; // minimal feasible speed
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; // avoid overflow
        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil(p/k) in integer math
            if (hours > h) return false; // early exit
        }
        return hours <= h;
    }
}
