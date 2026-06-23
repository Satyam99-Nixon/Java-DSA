Problem Statement

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1
Input: s = "bcabc"
Output: "abc"
Example 2
Input: s = "cbacdcbc"
Output: "acdb"
Constraints
1 <= s.length <= 10^4
s consists of lowercase English letters.


java...



import java.util.*;

class Solution {
    puiblic String removeDuplicateLetters(String s) {
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > c
                    && last[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}

Time Complexity: O(n)
Space Complexity: O(1) (26 lowercase letters)
