package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromicSubstringsSolution1 {

    static class SubStringInfo {
        int startIndex, endIndex;
        String subString;

        public SubStringInfo(int startIndex, int endIndex, String subString) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.subString = subString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SubStringInfo)) return false;
            SubStringInfo that = (SubStringInfo) o;
            return startIndex == that.startIndex &&
                    endIndex == that.endIndex &&
                    Objects.equals(subString, that.subString);
        }

        @Override
        public int hashCode() {

            return Objects.hash(startIndex, endIndex, subString);
        }

        @Override
        public String toString() {
            return "SubStringInfo{" +
                    "startIndex=" + startIndex +
                    ", endIndex=" + endIndex +
                    ", subString='" + subString + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("aaaa"));

        System.out.println(countSubstrings("xkjkqlajprjwefilxgpdpebieswu"));

    }

    public static int countSubstrings(String s) {
        ArrayList<SubStringInfo> subStringList = new ArrayList<>();
        new PalindromicSubstringsSolution1().allSubStrings(s, subStringList, 0, s.length());

        return subStringList.size();
    }

    private void allSubStrings(String str, List<SubStringInfo> subStringList, int left, int right) {
        if (left >= right) {
            return;
        }

        SubStringInfo substringInfo = new SubStringInfo(left, right, str.substring(left, right));
        if (!subStringList.contains(substringInfo) && isPalindrome(substringInfo.subString)) {
            System.out.println(substringInfo);
            subStringList.add(substringInfo);
        }

        allSubStrings(str, subStringList, left, right - 1);
        allSubStrings(str, subStringList, left + 1, right);
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
