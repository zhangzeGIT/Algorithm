package com.bytedance.leetcode;

import java.util.Arrays;

/**
 * 5. Longest Palindromic Substring
 * 最长回文字符串
 */
public class LongestPalindrome {
    // 动态规划：P(i，j) = true (字串P（i + 1, j - 1）也是回文的情况)
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return s;
        }
        int len = chars.length;
        boolean[][] result = new boolean[len][len];
        int begin = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            result[i][i] = true;
        }
        // 枚举字符串的长度
        for (int L = 2; L <= len; L++) {
            // 设置左边界
            for (int i = 0; i < len;i++) {
                // 得到右边界
                int j = L + i - 1;
                if (j >= len) { break; }
                if (chars[i] != chars[j]) {
                    result[i][j] = false;
                } else {
                    if (j - i < 3) {
                        result[i][j] = true;
                    }else {
                        result[i][j] = result[i+1][j-1];
                    }
                }
                if (result[i][j] && j - i + 1 > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    // 中心扩展算法：P(i,j)←P(i+1,j−1)←P(i+2,j−2)←⋯←某一边界情况
    // 遍历选取字符串的中心，向两边扩展，直到遇到不相等的情况
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length();i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) /2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
