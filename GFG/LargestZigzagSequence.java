class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] prev = new int[n];
        for (int j = 0; j < n; j++) {
            prev[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = -1, max2 = -1, idx = -1;

            for (int j = 0; j < n; j++) {
                if (prev[j] > max1) {
                    max2 = max1;
                    max1 = prev[j];
                    idx = j;
                } else if (prev[j] > max2) {
                    max2 = prev[j];
                }
            }

            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                curr[j] = mat[i][j] + (j == idx ? max2 : max1);
            }

            prev = curr;
        }

        int ans = 0;
        for (int val : prev) {
            ans = Math.max(ans, val);
        }

        return ans;
    }
}
