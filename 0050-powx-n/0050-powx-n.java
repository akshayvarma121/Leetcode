class Solution {
    public double myPow(double x, int n) {
        long exp = n;            // promote to long
        if (exp < 0) {
            x = 1 / x;           // x^(-n) = (1/x)^n
            exp = -exp;          // safe because exp is long
        }
        return fastPow(x, exp);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);

        if ((n & 1) == 0) {
            return half * half;       // even exponent
        } else {
            return half * half * x;   // odd exponent
        }
    }
}