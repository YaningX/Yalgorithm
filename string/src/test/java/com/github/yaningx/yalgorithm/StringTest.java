package com.github.yaningx.yalgorithm;

import org.junit.Test;

public class StringTest {
    @Test
    public void longestCommonPrefixTest() {
        String[] strings = new String[] {"hello", "hellohello", "hellohellohihi", "hello,hi"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strings));
    }
}
