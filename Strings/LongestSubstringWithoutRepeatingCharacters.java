// Longest Substring Without Repeating Characters

// Example 1
Input: s = "abcabcbb"
Output: 3

// Example 2
Input: s = "bbbbb"
Output: 1

// Example 3
Input: s = "pwwkew"
Output: 3

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
