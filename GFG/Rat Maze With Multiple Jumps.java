Problem Of The Day
  24 June 2026

Rat Maze With Multiple Jumps



class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] path = new int[n][n];
        boolean[][] bad = new boolean[n][n];

        if (mat[0][0] == 0 || !solve(0, 0, mat, path, bad, n)) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(-1);
            ans.add(row);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    private boolean solve(int r, int c, int[][] mat,
                          int[][] path, boolean[][] bad, int n) {

        if (r >= n || c >= n || mat[r][c] == 0)
            return false;

        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }

        if (bad[r][c])
            return false;

        path[r][c] = 1;

        int jump = mat[r][c];

        for (int step = 1; step <= jump; step++) {

            // Right first (as required)
            if (c + step < n &&
                solve(r, c + step, mat, path, bad, n))
                return true;

            // Then Down
            if (r + step < n &&
                solve(r + step, c, mat, path, bad, n))
                return true;
        }

        path[r][c] = 0;
        bad[r][c] = true; // memoize dead state

        return false;
    }
}
