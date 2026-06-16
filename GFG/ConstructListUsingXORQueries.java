Construct List using XOR Queries

There is an array that initially contains only a single value, 0.

Given a list of queries[][]:
1. [0, x] -> Insert x into the array.
2. [1, x] -> Replace every element a in the array with a ^ x.

Return the array in sorted order after performing all the queries.



Solution 

java....
  
  import java.util.*;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        int xr = 0;

        ans.add(0);

        for (int[] q : queries) {
            if (q[0] == 0) {
                ans.add(q[1] ^ xr);
            } else {
                xr ^= q[1];
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) ^ xr);
        }

        Collections.sort(ans);
        return ans;
    }
}
