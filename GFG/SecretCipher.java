class Solution {

    public String compress(String s) {

        int n = s.length();

        // LPS array (KMP prefix function)
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {

            int j = lps[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        StringBuilder ans = new StringBuilder();

        int i = n - 1;

        while (i >= 0) {

            // Only even length prefix can be compressed
            if (i % 2 == 1) {

                int len = i + 1;
                int half = len / 2;

                /*
                 * Check whether the complete string is
                 * made by repeating a prefix.
                 *
                 * lps[i] >= half means that the prefix
                 * and suffix of length half match.
                 */
                if (lps[i] >= half &&
                    len % (2 * (len - lps[i])) == 0) {

                    ans.append('*');

                    // Move to the first half
                    i = half - 1;

                    continue;
                }
            }

            ans.append(s.charAt(i));
            i--;
        }

        return ans.reverse().toString();
    }
}
