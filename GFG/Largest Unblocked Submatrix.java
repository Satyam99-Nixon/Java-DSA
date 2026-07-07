
import java.util.*;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int[] cell : arr) {
            rows.add(cell[0]);
            cols.add(cell[1]);
        }

        Collections.sort(rows);
        Collections.sort(cols);

        int maxRow = 0;
        int prev = 0;

        for (int r : rows) {
            maxRow = Math.max(maxRow, r - prev - 1);
            prev = r;
        }
        maxRow = Math.max(maxRow, n - prev);

        int maxCol = 0;
        prev = 0;

        for (int c : cols) {
            maxCol = Math.max(maxCol, c - prev - 1);
            prev = c;
        }
        maxCol = Math.max(maxCol, m - prev);

        return maxRow * maxCol;
    }
}
