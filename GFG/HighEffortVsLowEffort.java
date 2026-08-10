class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        if (n == 1)
            return Math.max(h[0], l[0]);

        int prev2 = 0;
        int prev1 = Math.max(h[0], l[0]);

        for (int i = 1; i < n; i++) {
            int curr = Math.max(prev1 + l[i], prev2 + h[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
