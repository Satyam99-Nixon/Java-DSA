class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        
        // dp[inc][dec] = maximum selected elements
        // inc = last value of increasing subsequence
        // dec = last value of decreasing subsequence
        int[][] dp = new int[101][101];
        
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = -1;
            }
        }
        
        dp[0][100] = 0;
        
        for (int x : arr) {
            int[][] next = new int[101][101];
            
            for (int i = 0; i <= 100; i++) {
                for (int j = 0; j <= 100; j++) {
                    next[i][j] = dp[i][j];
                }
            }
            
            for (int inc = 0; inc <= 100; inc++) {
                for (int dec = 0; dec <= 100; dec++) {
                    if (dp[inc][dec] == -1)
                        continue;
                    
                    // Put x in increasing subsequence
                    if (inc == 0 || x > inc) {
                        next[x][dec] = Math.max(
                            next[x][dec],
                            dp[inc][dec] + 1
                        );
                    }
                    
                    // Put x in decreasing subsequence
                    if (dec == 100 || x < dec) {
                        next[inc][x] = Math.max(
                            next[inc][x],
                            dp[inc][dec] + 1
                        );
                    }
                }
            }
            
            dp = next;
        }
        
        int maxSelected = 0;
        
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                maxSelected = Math.max(maxSelected, dp[i][j]);
            }
        }
        
        return n - maxSelected;
    }
}
