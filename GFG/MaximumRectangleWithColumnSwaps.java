import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Calculate consecutive 1s ending at current row
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // Since columns can be swapped,
            // sort heights in descending order
            int[] sorted = height.clone();
            Arrays.sort(sorted);

            // Try every possible width
            for (int j = 0; j < m; j++) {
                int width = m - j;
                int h = sorted[j];

                maxArea = Math.max(maxArea, h * width);
            }
        }

        return maxArea;
    }
}
