package com.github.cjzhusu.dashleetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (null == s || s.isEmpty()) {
            return "";
        }

        if (numRows <= 1) {
            return s;
        }

        List<List<Character>> zigZag = new ArrayList<>();
        int len = s.length();
        int denominator = 2 * (numRows - 1);
        int quotient = len / denominator;
        int residue = len % denominator;
        int clus = (numRows - 1) * quotient + residue / numRows + residue % numRows;
        for (int i = 0; i < clus; i++) {
            List<Character> charList = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                if (j + i * 2 < len) {
                    if (i % (numRows - 1) == 0) {
                        charList.add(s.charAt(j + i * 2));
                    } else {
                        if ((i + j) % (numRows - 1) == 0) {
                            charList.add(s.charAt(j + i * 2));
                        } else {
                            charList.add(null);
                        }
                    }
                } else {
                    charList.add(null);
                }
            }

            zigZag.add(charList);
        }

        String str = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < clus; j++) {
                if (null != zigZag.get(j).get(i)) {
                    str += zigZag.get(j).get(i);
                }
            }
        }

        return str;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 20;
        System.out.println(new ZigZagConversion().convert(s, numRows));
    }
}
