class Solution {
    static final int MOD = 1000000007;

    public int countWays(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (m > n) return 0;

        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[j + 1] = (dp[j + 1] + dp[j]) % MOD;
                }
            }
        }

        return (int) dp[m];
    }
}
