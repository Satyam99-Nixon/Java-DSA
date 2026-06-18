Longest Repeating Character Replacement

Given a string s and an integer k, you can choose any character of the string and change it to any other uppercase English character at most k times.

Return the length of the longest substring containing the same letter you can get after performing at most k replacements.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace one 'A' in the middle with 'B' and form "AABBBBA".
The longest repeating substring is "BBBB", which has length 4.


import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq,
                    count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {

                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength,
                    right - left + 1);
        }

        return maxLength;
    }
}
