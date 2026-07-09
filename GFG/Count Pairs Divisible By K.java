class Solution {
    public static int countKdivPairs(int[] arr, int k) {

        int[] freq = new int[k];

        // Count frequency of remainders
        for (int num : arr) {
            freq[num % k]++;
        }

        int count = 0;

        // Pairs with remainder 0
        count += (freq[0] * (freq[0] - 1)) / 2;

        // Pairs of i and k-i
        for (int i = 1; i <= (k - 1) / 2; i++) {
            count += freq[i] * freq[k - i];
        }

        // If k is even
        if (k % 2 == 0) {
            count += (freq[k / 2] * (freq[k / 2] - 1)) / 2;
        }

        return count;
    }
}
