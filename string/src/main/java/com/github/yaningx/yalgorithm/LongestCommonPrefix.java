package com.github.yaningx.yalgorithm;

/**
 * leetcode 14
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        if (strs.length == 0) {
            return commonPrefix.toString();
        }
        for (int i = 0; i < strs[0].length(); i++) {
            commonPrefix.append(strs[0].charAt(i));
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(commonPrefix.toString())) {
                    return commonPrefix.substring(0, commonPrefix.length() - 1);
                }
            }
        }
        return commonPrefix.toString();
    }
}
