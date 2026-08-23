import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#')
            return 0;

        int INF = Integer.MAX_VALUE;

        // Minimum upward moves required to reach each cell
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        // 0-1 BFS
        Deque<int[]> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.offerFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();

            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (mat[nx][ny] == '#')
                    continue;

                // Only moving UP costs 1
                int cost = (nx < x) ? 1 : 0;

                int newDist = dist[x][y] + cost;

                if (newDist < dist[nx][ny]) {

                    dist[nx][ny] = newDist;

                    if (cost == 1)
                        dq.offerLast(new int[]{nx, ny});
                    else
                        dq.offerFirst(new int[]{nx, ny});
                }
            }
        }

        int count = 0;

        // Count each cell exactly once
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (dist[i][j] == INF)
                    continue;

                int upMoves = dist[i][j];

                // down - up = currentRow - startingRow
                int downMoves = upMoves + (i - r);

                if (upMoves <= u && downMoves <= d) {
                    count++;
                }
            }
        }

        return count;
    }
}
