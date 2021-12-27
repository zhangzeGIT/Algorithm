package com.bytedance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 *
 * give string is
 * PAYPALISHIRING
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * convert to
 *
 * PAHNAPLSIIGYIR
 */
public class ZigZag {
    // 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
    // 初始化nubRows个StringBuffer，通过控制变量看是向上遍历，还是向下遍历
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        for (int i =0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuffer());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows -1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuffer sb = new StringBuffer();
        for (StringBuffer row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }

    // 按行访问
    //行 0 中的字符位于索引 k (2 * numRows - 2 + 0)处;
    //行 numRows−1 中的字符位于索引 k(2 * numRows - 2) + numRows−1 处;
    //内部的 行 i 中的字符位于索引k(2⋅numRows−2) + i 以及 (k+1)(2⋅numRows−2) − i 处；
    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) throws Exception{
        String s = ZigZag.class.newInstance().convert1("zhangze", 3);
        System.out.println(s);
    }
}
