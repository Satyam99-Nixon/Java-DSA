import java.util.*;

class Solution {

    static class Node {
        int val, row, col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int[] findSmallestRange(int[][] arr, int n, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        int max = Integer.MIN_VALUE;

        // Insert first element from each list
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (pq.size() == k) {

            Node curr = pq.poll();
            int min = curr.val;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // Move to next element in the same list
            if (curr.col + 1 < n) {
                int nextVal = arr[curr.row][curr.col + 1];
                pq.offer(new Node(nextVal, curr.row, curr.col + 1));
                max = Math.max(max, nextVal);
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }
}
