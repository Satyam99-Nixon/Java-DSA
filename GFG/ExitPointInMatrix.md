# Exit Point in a Matrix

## Problem

Given a matrix `mat[][]` of size `n x m` consisting of 0s and 1s.

You start at cell `(0,0)` and initially move towards the right.

Rules:

- If the current cell contains `0`, continue moving in the same direction.
- If the current cell contains `1`, turn right (clockwise), change the cell value to `0`, and continue.

Find the coordinates `(row, column)` of the cell from which you exit the matrix.

### Example

Input:

[[0,1,0],
 [0,1,1],
 [0,0,0]]

Output:

[1,0]

---

## Approach

- Maintain current direction:
  - 0 = Right
  - 1 = Down
  - 2 = Left
  - 3 = Up
- Whenever a `1` is encountered:
  - Turn right.
  - Convert `1` to `0`.
- Move according to the current direction.
- When we go outside the matrix, return the last valid cell.

### Time Complexity

O(N × M)

### Space Complexity

O(1)

---

## Java Solution

```java
import java.util.*;

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int i = 0, j = 0;
        int dir = 0;

        while (i >= 0 && i < n && j >= 0 && j < m) {

            if (mat[i][j] == 1) {
                dir = (dir + 1) % 4;
                mat[i][j] = 0;
            }

            if (dir == 0) j++;
            else if (dir == 1) i++;
            else if (dir == 2) j--;
            else i--;
        }

        if (dir == 0) j--;
        else if (dir == 1) i--;
        else if (dir == 2) j++;
        else i++;

        return Arrays.asList(i, j);
    }
}
