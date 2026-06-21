Find All Anagrams In A String

Given two strings s and p, return an array of all the start indices of p's anagrams in s.

You may return the answer in any order.

Example 1:

Input:
s = "cbaebabacd"
p = "abc"

Output:
[0,6]

Example 2:

Input:
s = "abab"
p = "ab"

Output:
[0,1,2]


// Find All Anagrams In A String

// Example 1
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]

// Example 2
Input: s = "abab", p = "ab"
Output: [0,1,2]

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {

            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
