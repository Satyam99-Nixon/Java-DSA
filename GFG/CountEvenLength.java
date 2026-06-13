# Count Even Length

## Problem
Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.

### Example
Input:
n = 2

Output:
6

Explanation:
The sequences are:
0101, 0110, 1010, 1001, 0000, 1111

## Java Solution

```java
class Solution {
    static final long MOD = 1000000007;

    long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int computeValue(int n) {
        long num = 1, den = 1;

        for (int i = 1; i <= n; i++) {
            num = (num * (n + i)) % MOD;
            den = (den * i) % MOD;
        }

        return (int)((num * power(den, MOD - 2)) % MOD);
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
