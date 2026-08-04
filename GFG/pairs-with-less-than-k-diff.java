import java.util.Arrays;

class Solution {
    int countPairs(int[] arr, int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int left = 0, right = 1;
        int count = 0;

        while (right < n) {
            if (arr[right] - arr[left] < k) {
                count += (right - left);
                right++;
            } else {
                left++;
                if (left == right) {
                    right++;
                }
            }
        }

        return count;
    }
}
