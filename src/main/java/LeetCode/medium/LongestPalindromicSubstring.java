package LeetCode.medium;

import java.util.Arrays;

/**
 * Created by bresai on 2017/1/4.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (s.length() == 0){
            return "";
        }

        int number = 0;
        int maxStart = 0,maxEnd = 0;
        int start = 0;
        for(int i = 1; i < chars.length; i++){
            if (i - start - 2 < 0 || chars[i - 2] == chars[i]){
            } else{
                if (chars[i - 1] == chars[start]) {
                    if ( i - start > number || number == 2){
                        maxStart = start;
                        maxEnd = i;
                        number = i - start;
                    }
                    start = i - 1;
                } else{
                    if ( i - start - 1 > number || number == 2){
                        maxStart = start;
                        maxEnd = i - 1;
                        number = i - start - 1;
                    }
                    start = i - 2;
                }
            }
        }
        if ( chars.length - start > number){
            maxStart = start;
            maxEnd = chars.length;
        }

        return String.valueOf(Arrays.copyOfRange(chars, maxStart, maxEnd));
    }

    public static void main(String[] args){
        LongestPalindromicSubstring object = new LongestPalindromicSubstring();
        System.out.println(object.longestPalindrome("cbbd"));
    }
}
