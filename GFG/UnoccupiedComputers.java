class Solution {
    public int solve(int n, String s) {
        // 0 = not arrived
        // 1 = using a computer
        // 2 = rejected
        int[] state = new int[26];

        int occupied = 0;
        int rejected = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';

            if (state[idx] == 0) {
                // First occurrence: arrival
                if (occupied < n) {
                    state[idx] = 1;
                    occupied++;
                } else {
                    state[idx] = 2;
                    rejected++;
                }
            } else if (state[idx] == 1) {
                // Assigned customer leaves
                state[idx] = 0;
                occupied--;
            } else {
                // Rejected customer's departure
                state[idx] = 0;
            }
        }

        return rejected;
    }
}
