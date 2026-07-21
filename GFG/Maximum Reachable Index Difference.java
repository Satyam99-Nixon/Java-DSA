class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();

        // dp[i] = farthest index reachable starting from i
        int[] dp = new int[n];

        // best[c] = maximum dp value among processed indices having character c
        int[] best = new int[26];
        for (int i = 0; i < 26; i++) best[i] = -1;

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';

            dp[i] = i;

            if (ch < 25 && best[ch + 1] != -1) {
                dp[i] = best[ch + 1];
            }

            best[ch] = Math.max(best[ch], dp[i]);

            if (ch == 0) {
                ans = Math.max(ans, dp[i] - i);
            }
        }

        return ans;
    }
}
