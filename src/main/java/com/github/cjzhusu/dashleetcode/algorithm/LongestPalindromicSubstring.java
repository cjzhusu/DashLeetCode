package com.github.cjzhusu.dashleetcode.algorithm;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }

        int left_ind = 0, right_ind = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd_len = expandAroundCenter(s, i, i);
            int even_len = expandAroundCenter(s, i, i + 1);
            int len = Math.max(odd_len, even_len);
            if (len > right_ind - left_ind) {
                left_ind = i - (len - 1) / 2;
                right_ind = i + len / 2;
            }
        }

        return s.substring(left_ind, right_ind + 1);
    }

    private int expandAroundCenter(String s, int left_ind, int right_ind) {
        while (left_ind >= 0 && right_ind < s.length() && s.charAt(left_ind) == s.charAt(right_ind)) {
            left_ind--;
            right_ind++;
        }

        return right_ind - left_ind - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
}
