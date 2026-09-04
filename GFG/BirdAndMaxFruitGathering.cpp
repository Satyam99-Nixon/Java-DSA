class Solution {
  public:
    int maxFruits(vector<int>& arr, int m) {
        int n = arr.size();

        long long sum = 0;
        long long ans = 0;

        // First window
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        ans = sum;

        // Slide window over circular array
        for (int i = m; i < n + m - 1; i++) {
            sum -= arr[(i - m) % n];
            sum += arr[i % n];

            ans = max(ans, sum);
        }

        return (int)ans;
    }
};
