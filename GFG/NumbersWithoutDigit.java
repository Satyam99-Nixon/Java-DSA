class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();

        long[] pow = new long[len + 1];
        pow[0] = 1;

        for (int i = 1; i <= len; i++) {
            pow[i] = pow[i - 1] * 9;
        }

        long ans = 0;

        // Numbers with fewer digits
        for (int digits = 1; digits < len; digits++) {
            ans += 9 * pow[digits - 1];
        }

        // Numbers with same number of digits
        for (int i = 0; i < len; i++) {
            int current = s.charAt(i) - '0';
            int remaining = len - i - 1;

            int smaller = current;

            // First digit cannot be 0
            if (i == 0) {
                smaller--;
            }

            // Exclude digit d
            if (d < current) {
                smaller--;
            }

            if (smaller > 0) {
                ans += (long) smaller * pow[remaining];
            }

            // If current digit is d, stop
            if (current == d) {
                return (int) ans;
            }
        }

        // n itself does not contain d
        return (int) ans + 1;
    }
}
