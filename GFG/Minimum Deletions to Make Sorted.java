class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;

        int[] lis = new int[n];
        int len = 0;

        for (int num : arr) {
            int left = 0, right = len;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lis[mid] < num)
                    left = mid + 1;
                else
                    right = mid;
            }

            lis[left] = num;

            if (left == len)
                len++;
        }

        return n - len;
    }
}
