class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] vis = new boolean[n][m];

        return dfs(mat, vis, xs, ys, xd, yd);
    }

    private int dfs(int[][] mat, boolean[][] vis,
                    int x, int y, int xd, int yd) {

        if (x == xd && y == yd)
            return 0;

        vis[x][y] = true;

        int max = -1;

        for (int k = 0; k < 4; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (isValid(mat, vis, nx, ny)) {

                int dist = dfs(mat, vis, nx, ny, xd, yd);

                if (dist != -1)
                    max = Math.max(max, dist + 1);
            }
        }

        vis[x][y] = false; // Backtrack

        return max;
    }

    private boolean isValid(int[][] mat, boolean[][] vis,
                            int x, int y) {

        int n = mat.length;
        int m = mat[0].length;

        return x >= 0 && x < n &&
               y >= 0 && y < m &&
               mat[x][y] == 1 &&
               !vis[x][y];
    }
}
