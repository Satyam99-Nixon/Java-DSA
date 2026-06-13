class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }

        String cleaned = str.toString();
        int left = 0, right = cleaned.length() - 1;

        while(left < right) {
            if(cleaned.charAt(left) != cleaned.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
