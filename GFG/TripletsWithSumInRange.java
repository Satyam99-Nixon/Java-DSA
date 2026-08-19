import java.util.*;

class Solution {

    long countTriplets(int[] arr, int x) {
        Arrays.sort(arr);

        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                long sum = (long) arr[i] + arr[j] + arr[k];

                if (sum <= x) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    public long countTriplets(int[] arr, int l, int r) {
        return countTriplets(arr, r) - countTriplets(arr, l - 1);
    }
}
