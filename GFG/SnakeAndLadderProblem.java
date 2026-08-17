import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int total = n * n;

        // jump[i] = destination if there is a snake/ladder at i
        int[] jump = new int[total + 1];

        // Ladders
        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        // Snakes
        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[total + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int throwsCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();

                if (current == total) {
                    return throwsCount;
                }

                // Try all possible dice throws: 1 to 6
                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;

                    if (next > total) {
                        break;
                    }

                    // Take snake or ladder immediately
                    if (jump[next] != 0) {
                        next = jump[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            throwsCount++;
        }

        return -1;
    }
}
