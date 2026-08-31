import java.util.*;

class Solution {
    public int minCost(int n, int i, int d, int c) {

        long[] dp = new long[n + 1];

        // deque stores indices k
        // such that dp[k] + 2*k*d is increasing
        int[] deque = new int[n + 1];
        int head = 0, tail = 0;

        dp[0] = 0;

        for (int x = 1; x <= n; x++) {

            // Insert operation
            dp[x] = dp[x - 1] + i;

            // Add k = x - 1 to the deque.
            // k = 0 is not useful because copy-paste from
            // an empty string doesn't double anything.
            int k = x - 1;

            if (k > 0) {
                long value = dp[k] + 2L * k * d;

                // Remove elements whose value is >= current value
                while (head < tail) {
                    int last = deque[tail - 1];
                    long lastValue = dp[last] + 2L * last * d;

                    if (lastValue <= value) {
                        break;
                    }

                    tail--;
                }

                deque[tail++] = k;
            }

            // Valid k range:
            // ceil(x/2) <= k < x
            int left = (x + 1) / 2;

            // Remove indices outside the valid range
            while (head < tail && deque[head] < left) {
                head++;
            }

            // Copy-paste and then delete if necessary
            if (head < tail) {
                int bestK = deque[head];

                long best = dp[bestK]
                        + c
                        + (2L * bestK - x) * d;

                dp[x] = Math.min(dp[x], best);
            }
        }

        return (int) dp[n];
    }
}
