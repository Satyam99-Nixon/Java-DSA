class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int countCoordinates(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] stationP = new boolean[n][m];
        boolean[][] stationQ = new boolean[n][m];

        // Top row
        for (int j = 0; j < m; j++)
            dfs(0, j, stationP, mat);

        // Left column
        for (int i = 0; i < n; i++)
            dfs(i, 0, stationP, mat);

        // Bottom row
        for (int j = 0; j < m; j++)
            dfs(n - 1, j, stationQ, mat);

        // Right column
        for (int i = 0; i < n; i++)
            dfs(i, m - 1, stationQ, mat);

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (stationP[i][j] && stationQ[i][j])
                    count++;
            }
        }

        return count;
    }

    void dfs(int r, int c, boolean[][] vis, int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (vis[r][c])
            return;

        vis[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                !vis[nr][nc] &&
                mat[nr][nc] >= mat[r][c]) {

                dfs(nr, nc, vis, mat);
            }
        }
    }
}
