import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public ArrayList<Integer> findWays(int[][] matrix) {
        int n = matrix.length;

        long[][] ways = new long[n][n];
        long[][] maxAdv = new long[n][n];

        ways[0][0] = 1;
        maxAdv[0][0] = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                // From LEFT
                if (j > 0) {
                    int left = matrix[i][j - 1];

                    if ((left == 1 || left == 3) && ways[i][j - 1] > 0) {

                        ways[i][j] =
                            (ways[i][j] + ways[i][j - 1]) % MOD;

                        maxAdv[i][j] = Math.max(
                            maxAdv[i][j],
                            maxAdv[i][j - 1] + matrix[i][j]
                        );
                    }
                }

                // From TOP
                if (i > 0) {
                    int top = matrix[i - 1][j];

                    if ((top == 2 || top == 3) && ways[i - 1][j] > 0) {

                        ways[i][j] =
                            (ways[i][j] + ways[i - 1][j]) % MOD;

                        maxAdv[i][j] = Math.max(
                            maxAdv[i][j],
                            maxAdv[i - 1][j] + matrix[i][j]
                        );
                    }
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int) ways[n - 1][n - 1]);

        // If no path exists, maximum adventure must be 0
        if (ways[n - 1][n - 1] == 0) {
            ans.add(0);
        } else {
            ans.add((int) maxAdv[n - 1][n - 1]);
        }

        return ans;
    }
}
