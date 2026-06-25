class Solution {
    ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }

        if (n > 9) return result;

        generate(result, n, 1, 0);

        return result;
    }

    private void generate(ArrayList<Integer> result, int n, int start, int num) {
        if (n == 0) {
            result.add(num);
            return;
        }

        for (int digit = start; digit <= 9; digit++) {
            generate(result, n - 1, digit + 1, num * 10 + digit);
        }
    }
}
