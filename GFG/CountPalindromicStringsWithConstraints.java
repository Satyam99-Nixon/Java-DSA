class Solution {
    public int palindromicStrings(int n, int k) {
        final long MOD = 1_000_000_007L;

        long ans = 0;
        long perm = 1; // P(k, 0)

        for (int m = 1; m <= (n + 1) / 2; m++) {
            // P(k, m) = P(k, m-1) * (k-m+1)
            perm = (perm * (k - m + 1)) % MOD;

            // Length = 2m - 1
            ans = (ans + perm) % MOD;

            // Length = 2m
            if (2 * m <= n) {
                ans = (ans + perm) % MOD;
            }
        }

        return (int) ans;
    }
}
