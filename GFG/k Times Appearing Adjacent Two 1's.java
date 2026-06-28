class Solution {
    static final int MOD = 1000000007;

    public int countStrings(int n, int k) {
        int[][][] dp = new int[n + 1][k + 1][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Place 0
                dp[i][j][0] = (int)(((long)dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD);

                // Place 1 after 0
                dp[i][j][1] = dp[i - 1][j][0];

                // Place 1 after 1 (creates one adjacent pair)
                if (j > 0) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % MOD;
                }
            }
        }

        return (dp[n][k][0] + dp[n][k][1]) % MOD;
    }
}
