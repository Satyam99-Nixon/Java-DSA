class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        // maxEndHere[i] = maximum subarray sum ending at i
        int[] maxEndHere = new int[n];
        maxEndHere[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndHere[i] = Math.max(arr[i], maxEndHere[i - 1] + arr[i]);
        }

        // Sum of first k elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int ans = sum;

        // Slide the window
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];

            // Subarray of exactly k elements
            ans = Math.max(ans, sum);

            // Extend with previous positive sum
            ans = Math.max(ans, sum + maxEndHere[i - k]);
        }

        return ans;
    }
}
