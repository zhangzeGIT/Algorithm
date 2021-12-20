package com.bytedance.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LengthOfLongestSubstring {
    // 解题思路：滑动窗口
    public int lengthOfLongestSubstring(String s) {
        char[] charS = s.toCharArray();
        int i = 0;
        int j = 0;
        int max = 0;
        if (charS.length <= 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for (; j < charS.length;j++) {
            while (set.contains(charS[j])) {
                set.remove(charS[i]);
                i++;
            }
            set.add(charS[j]);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) throws Exception{
        LengthOfLongestSubstring.class.newInstance().lengthOfLongestSubstring(" ");
    }
}
