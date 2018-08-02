package arrayandstring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestNonRepeatingSubstring {


    public static void main(String[] args) {
        LongestNonRepeatingSubstring longestNonRepeatingSubstring = new LongestNonRepeatingSubstring();
        System.out.println(longestNonRepeatingSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestNonRepeatingSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestNonRepeatingSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestNonRepeatingSubstring.lengthOfLongestSubstring(" "));
        System.out.println(longestNonRepeatingSubstring.lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(longestNonRepeatingSubstring.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!"));
    }

    public int lengthOfLongestSubstring(String s) {
        boolean[] visitCount = new boolean[('~' - ' ') + 1];
        int maxSubString = 0;
        char[] chars = s.toCharArray();

        List<Character> subStr = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(visitCount, false);
            subStr.clear();
            for (int j = i; j < chars.length; j++) {
                char ch = chars[j];
                int idx = ch - ' ';
                if (visitCount[idx]) {
                    break;
                } else {
                    subStr.add(ch);
                    visitCount[idx] = true;
                    int size = subStr.size();
                    if (size > maxSubString) {
                        maxSubString = size;
                    }
                }

            }
        }

        return maxSubString;
    }

}
