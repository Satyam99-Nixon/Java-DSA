class Solution {
    public int getCount(int n) {
        int count = 0;

        for (int k = 2; k * (k + 1) / 2 <= n; k++) {
            if ((2 * n) % k != 0)
                continue;

            int temp = (2 * n) / k - k + 1;

            if (temp > 0 && temp % 2 == 0)
                count++;
        }

        return count;
    }
}
