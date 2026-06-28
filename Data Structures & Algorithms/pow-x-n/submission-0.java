class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;        // 0^0 -> 1
        if (x == 0.0) return 0.0;      // 0^positive -> 0
        long exp = Math.abs((long) n); // avoid overflow on MIN_VALUE
        double res = fastPow(x, exp);
        return n >= 0 ? res : 1.0 / res;
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if ((n & 1L) == 0) return half * half;  // even
        return x * half * half;                 // odd
    }
}
