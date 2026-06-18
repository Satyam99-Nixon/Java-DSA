Coverage of all Zeros in a Binary Matrix

  
Given a binary matrix mat[][] containing only 0s and 1s, find the total coverage of all 0's. The coverage of a particular 0 cell is defined by checking 1's in its four directions (left, right, up, and down). For each direction, if there is at least one 1 anywhere between the 0 and the boundary of the matrix, the coverage increases by one.

Return the sum of the coverage values for all 0 cells in the matrix.



  class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    int coverage = 0;

                    // Left
                    for (int k = j - 1; k >= 0; k--) {
                        if (mat[i][k] == 1) {
                            coverage++;
                            break;
                        }
                    }

                    // Right
                    for (int k = j + 1; k < m; k++) {
                        if (mat[i][k] == 1) {
                            coverage++;
                            break;
                        }
                    }

                    // Up
                    for (int k = i - 1; k >= 0; k--) {
                        if (mat[k][j] == 1) {
                            coverage++;
                            break;
                        }
                    }

                    // Down
                    for (int k = i + 1; k < n; k++) {
                        if (mat[k][j] == 1) {
                            coverage++;
                            break;
                        }
                    }

                    ans += coverage;
                }
            }
        }

        return ans;
    }
}
