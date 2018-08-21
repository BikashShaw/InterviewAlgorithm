package string.palindromicsubstrings;

/**
 * Accepted by Leetcode
 */
public class PalindromicSubstringsSolution2 {

    public static void main(String[] args) {

        PalindromicSubstringsSolution2 palindromicSubstringsSolution4 = new PalindromicSubstringsSolution2();
        System.out.println(palindromicSubstringsSolution4.countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg"));
    }

    public int countSubstrings(String s) {
        int palindromeCount = 0;
        int n = s.length();
        int i = 0;


        while (i < n) {
            for (int j = 0; j < n; j++) {
                int start = j;
                int end = j + i;
                if (end >= n) {
                    break;
                }

                String substring = s.substring(start, end + 1);
                boolean palindrome = isPalindrome(substring);
                if (palindrome) {
                    palindromeCount++;
                }
                System.out.println(substring + " : " + palindrome);
            }
            i++;

        }
        return palindromeCount;
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
