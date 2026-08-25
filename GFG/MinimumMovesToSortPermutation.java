class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n + 1];

        // Position of each value
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int longest = 1;
        int current = 1;

        // Find longest consecutive values
        // whose positions are also increasing
        for (int value = 2; value <= n; value++) {
            if (pos[value] > pos[value - 1]) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return n - longest;
    }
}
