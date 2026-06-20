Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.

If there is no such substring, return an empty string "".

The testcases will be generated such that the answer is unique.


  // Minimum Window Substring

// Example 1
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

// Example 2
Input: s = "a", t = "a"
Output: "a"

// Example 3
Input: s = "a", t = "aa"
Output: ""

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = target.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (target.containsKey(c) &&
                window.get(c).intValue() == target.get(c).intValue()) {
                have++;
            }

            while (have == need) {

                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (target.containsKey(leftChar) &&
                    window.get(leftChar) < target.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
