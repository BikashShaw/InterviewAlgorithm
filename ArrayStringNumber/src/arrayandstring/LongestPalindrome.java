package arrayandstring;

/**
 * Time O(n^2), Space O(1)
 * Created by Bikash on 3/23/2017.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if(s == null) {
            return null;
        } else if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        String temp;

        for (int i = 0; i < s.length(); i++) {

            // get longest palindrome with center of i
            temp = helper(s,i,i);
            if(temp.length() > longest.length()) {
                longest = temp;
            }

            // get longest palindrome with center of i, i+1
            temp = helper(s,i,i+1);
            if(temp.length() > longest.length()) {
                longest = temp;
            }
        }


        return longest;
    }

    private String helper(String s,int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        return s.substring(begin+1, end);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        System.out.println(longestPalindrome.longestPalindrome("CBAIABA"));
    }
}
